package com.saude.agenda.api.patient;


import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.address.AddressAdapter;
import com.saude.agenda.api.patient.dto.PatientDto;
import com.saude.agenda.api.ubs.UbsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientAdapter implements Adapter<PatientDto, Patient> {

    @Autowired
    private AddressAdapter addressAdapter;

    @Autowired
    private UbsAdapter ubsAdapter;

    @Override
    public PatientDto fromEntity(Patient patient) {
        return new PatientDto(
                patient.getSusCode(),
                patient.getId(),
                patient.getName(),
                patient.getMotherName(),
                patient.getFatherName(),
                patient.getBirthDate(),
                patient.getBirthCity(),
                patient.getBirthUf(),
                patient.getEmail(),
                patient.getGender(),
                patient.getDdd(),
                patient.getPhone(),
                patient.getCpf(),
                patient.getPassword(),
                patient.getActive(),
                addressAdapter.fromEntity(patient.getAddress()),
                ubsAdapter.fromEntity(patient.getUbs())
        );
    }

    @Override
    public Patient fromDto(PatientDto patientDto) {
        return new Patient(
                patientDto.getSusCode(),
                patientDto.getName(),
                patientDto.getMotherName(),
                patientDto.getFatherName(),
                patientDto.getBirthDate(),
                patientDto.getBirthCity(),
                patientDto.getBirthUf(),
                patientDto.getEmail(),
                patientDto.getGender(),
                patientDto.getDdd(),
                patientDto.getPhone(),
                patientDto.getCpf(),
                patientDto.getPassword(),
                patientDto.getActive(),
                addressAdapter.fromDto(patientDto.getAddress()),
                ubsAdapter.fromDto(patientDto.getUbs())
        );
    }

}
