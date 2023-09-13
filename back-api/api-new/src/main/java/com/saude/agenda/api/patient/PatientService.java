package com.saude.agenda.api.patient;

import com.saude.agenda.api.exception.PatientNotFoundException;
import com.saude.agenda.api.patient.dto.PatientDto;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientAdapter adapter;

    public List<PatientDto> getAll() {
        return patientRepository.findAll().stream().map(this::getPatientDto).toList();
    }

    public PatientDto getPatientDto(Patient patient) {
        return  adapter.fromEntity(patient);
    }

    public PatientDto register(PatientDto data) {
        Patient patient = adapter.fromDto(data);
        patientRepository.save(patient);
        return adapter.fromEntity(patient);
    }

    public PatientDto getById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityExistsException("Patient not found"));
        return adapter.fromEntity(patient);
    }

//find Patient by Id
    public Patient findPatientById(Long patientId) throws PatientNotFoundException {
        Optional<Patient> patientToSearch = patientRepository.findById(patientId);

        if(patientToSearch.isPresent()){
            return patientToSearch.get();
        } throw new PatientNotFoundException();
    }

}
