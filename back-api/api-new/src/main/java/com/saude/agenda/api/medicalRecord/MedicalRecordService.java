package com.saude.agenda.api.medicalRecord;

import com.saude.agenda.api.medicalRecord.dto.MedicalRecordDto;
import com.saude.agenda.api.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public List<MedicalRecordDto> findMedicalRecordByPatientOrderByDate(Patient patient) {
        return medicalRecordRepository.findMedicalRecordByPatientOrderByDate(patient);
    }

}
