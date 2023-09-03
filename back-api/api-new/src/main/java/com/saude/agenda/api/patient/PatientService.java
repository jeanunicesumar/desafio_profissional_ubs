package com.saude.agenda.api.patient;

import org.springframework.beans.factory.annotation.Autowired;

public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientAdapter adapter;
}
