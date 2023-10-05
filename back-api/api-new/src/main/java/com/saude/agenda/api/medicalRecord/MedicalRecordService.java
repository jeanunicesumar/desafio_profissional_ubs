package com.saude.agenda.api.medicalRecord;

import com.saude.agenda.api.medicalRecord.dto.MedicalRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private MedicalRecordAdapter adapter;

    public List<MedicalRecordDto> getAll() {
        return medicalRecordRepository.findAll().stream().map(this::getMedicalRecordDto).toList();
    }

    private MedicalRecordDto getMedicalRecordDto(MedicalRecord medicalRecord) {
        return adapter.fromEntity(medicalRecord);
    }

}
