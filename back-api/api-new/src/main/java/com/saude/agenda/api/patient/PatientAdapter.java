package com.saude.agenda.api.patient;

import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.medicalRecord.MedicalRecord;
import com.saude.agenda.api.medicalRecord.dto.MedicalRecordDto;

public class PatientAdapter implements Adapter<PatientDto, Patient> {
    @Override
    public PatientDto fromEntity(Patient patient) {
        return new MedicalRecordDto(
                medicalRecord.getId(),
                medicalRecord.getDescription(),
                medicalRecord.getMedicalRecordDate());
    }

    @Override
    public MedicalRecord fromDto(MedicalRecordDto medicalRecordDto) {
        return new MedicalRecord(
                medicalRecordDto.getId(),
                medicalRecordDto.getDescription(),
                medicalRecordDto.getMedicalRecordDate());
    }
}
