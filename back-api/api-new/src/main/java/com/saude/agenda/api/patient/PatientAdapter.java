package com.saude.agenda.api.patient;


import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.patient.dto.PatientDto;
import com.saude.agenda.api.person.PersonAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientAdapter implements Adapter<PatientDto, Patient> {

    @Autowired
    private PersonAdapter personAdapter;

    @Override
    public PatientDto fromEntity(Patient patient) {
        return new PatientDto(patient.getId(), patient.getSusCode(), personAdapter.fromEntity(patient.getPerson()));
    }

    @Override
    public Patient fromDto(PatientDto patientDto) {
        return new Patient(patientDto.getSusCode(), personAdapter.fromDto(patientDto.getPerson()));
    }

}
