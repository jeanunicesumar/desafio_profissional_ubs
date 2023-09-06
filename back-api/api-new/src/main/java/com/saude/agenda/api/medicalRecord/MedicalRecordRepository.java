package com.saude.agenda.api.medicalRecord;

import com.saude.agenda.api.medicalRecord.dto.MedicalRecordDto;
import com.saude.agenda.api.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecordDto, Long> {
    List<MedicalRecordDto> findMedicalRecordByPatientOrderByDate(Patient patient);
}
