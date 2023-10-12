package com.saude.agenda.api.medicalRecord;

import com.saude.agenda.api.medicalRecord.dto.MedicalRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private MedicalRecordAdapter adapter;

    public Page<MedicalRecordDto> getAll(Pageable pageable) {
        return medicalRecordRepository.findAll(pageable).map(this::getMedicalRecordDto);
    }

    private MedicalRecordDto getMedicalRecordDto(MedicalRecord medicalRecord) {
        return adapter.fromEntity(medicalRecord);
    }

    public MedicalRecordDto register(MedicalRecordDto data) {
        MedicalRecord medicalRecord = adapter.fromDto(data);
        medicalRecordRepository.save(medicalRecord);
        return adapter.fromEntity(medicalRecord);
    }

}
