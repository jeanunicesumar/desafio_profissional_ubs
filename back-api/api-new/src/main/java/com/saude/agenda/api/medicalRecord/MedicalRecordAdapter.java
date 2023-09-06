package com.saude.agenda.api.medicalRecord;

import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.medicalRecord.dto.MedicalRecordDto;

public class MedicalRecordAdapter implements Adapter<MedicalRecordDto, MedicalRecord> {
    @Override
    public MedicalRecordDto fromEntity(MedicalRecord medicalRecord) {
        return new MedicalRecordDto(
                medicalRecord.getId(),
                medicalRecord.getDescription(),
                medicalRecord.getDate());
    }

    @Override
    public MedicalRecord fromDto(MedicalRecordDto medicalRecordDto) {
        return new MedicalRecord(
                medicalRecordDto.getId(),
                medicalRecordDto.getDescription(),
                medicalRecordDto.getDate());
    }
}
