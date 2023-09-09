package com.saude.agenda.api.patient;

import com.saude.agenda.api.exception.PatientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


    public Patient findPatientById(Long patientId) throws PatientNotFoundException {
        Optional<Patient> patientToSearch = patientRepository.findById(patientId);

        if(patientToSearch.isPresent()){
            return patientToSearch.get();
        } throw new PatientNotFoundException();
    }

}
