package com.saude.agenda.api.patient;

import com.saude.agenda.api.helper.HashPassword;
import com.saude.agenda.api.patient.dto.PatientDto;
import com.saude.agenda.api.patient.dto.PatientLoginDto;
import com.saude.agenda.api.patient.dto.PatientUpdateDto;
import jakarta.persistence.EntityExistsException;
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

    public List<PatientDto> getAll() {
        return repository.findAll().stream().map(this::getPatientDto).toList();
    }

    public PatientDto getPatientDto(Patient patient) {
        return  adapter.fromEntity(patient);
    }

    public PatientDto register(PatientDto data) {
        Patient patient = adapter.fromDto(data);
        repository.save(patient);
        return adapter.fromEntity(patient);
    }

    public PatientDto getById(Long id) {
        Patient patient = findById(id);
        return adapter.fromEntity(patient);
    }

    public Boolean login (PatientLoginDto data) {
        Patient patient = findBySusCode(data.getSusCode());
        return HashPassword.verifyPassword(data.getPassword(), patient.getPassword());
    }

    private Patient findById(Long patientId) {
        return repository.findById(patientId).
                orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado."));
    }

    public void updatePatient(Integer susCode, PatientUpdateDto patientUpdateDto){
        Patient patient = findBySusCode(susCode);
        patient.setEmail(patientUpdateDto.getEmail());
        patient.setPhone(patientUpdateDto.getPhone());

        repository.save(patient);
    }

    private Patient findBySusCode(Integer susCode) {
        return repository.findBySusCode(susCode).
                orElseThrow(() -> new EntityNotFoundException("Número SUS incorreto ou inexistente."));
    }

    public void deleteById(Long id) {
        Patient patient = findById(id);
        patient.setActive(false);
        repository.save(patient);
    }
}
