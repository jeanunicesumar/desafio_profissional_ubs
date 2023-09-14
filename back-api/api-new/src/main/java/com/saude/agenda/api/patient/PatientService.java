package com.saude.agenda.api.patient;

import com.saude.agenda.api.helper.HashPassword;
import com.saude.agenda.api.patient.dto.PatientDto;
import com.saude.agenda.api.patient.dto.PatientLoginDto;
import com.saude.agenda.api.patient.dto.PatientUpdateDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    @Autowired
    private PatientAdapter adapter;

    public List<PatientDto> getAll(){
        return repository.findAll().
                stream().map(this::getPatientDto).toList();
    }

    public PatientDto getPatientDto(Patient patient) {
        return adapter.fromEntity(patient);
    }

    public PatientDto register(PatientDto data) {
        data.setPassword(HashPassword.generateHash(data.getPassword()));
        Patient patient = adapter.fromDto(data);
        repository.save(patient);
        return adapter.fromEntity(patient);
    }

    public Boolean login (PatientLoginDto data) {
        Patient patient = findBySusCode(data.getSusCode());
        return HashPassword.verifyPassword(data.getPassword(), patient.getPassword());
    }

    private Patient findBySusCode(Integer susCode) {
        return repository.findBySusCode(susCode).
                orElseThrow(() -> new EntityNotFoundException("Número SUS incorreto ou inexistente."));
    }

    private Patient findPatientById(Long patientId) {
        return repository.findPatientById(patientId).
                orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado."));
    }

    public void updatePatient(Integer susCode, PatientUpdateDto patientUpdateDto){
        Patient patient = findBySusCode(susCode);
        if(patientUpdateDto.getEmail() != null)
            patient.setEmail(patientUpdateDto.getEmail());
        if(patientUpdateDto.getPhone() != null)
            patient.setPhone(patientUpdateDto.getPhone());

        repository.save(patient);
    }
}
