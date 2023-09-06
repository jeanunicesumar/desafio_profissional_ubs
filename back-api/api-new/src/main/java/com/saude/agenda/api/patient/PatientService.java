package com.saude.agenda.api.patient;

import com.saude.agenda.api.exception.PatientNotFoundException;
import com.saude.agenda.api.patient.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


//find Patient by Id
    public Patient findPatientById(Long patientId) throws PatientNotFoundException {
        Optional<Patient> patientToSearch = patientRepository.findById(patientId);

        if(patientToSearch.isPresent()){
            return patientToSearch.get();
        } throw new PatientNotFoundException();
    }

}
