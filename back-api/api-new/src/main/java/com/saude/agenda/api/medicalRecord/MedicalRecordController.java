package com.saude.agenda.api.medicalRecord;


import com.saude.agenda.api.medicalRecord.dto.MedicalRecordDto;
import com.saude.agenda.api.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("medicalRecord")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/medicalRecord/{patientId}")
    public List<MedicalRecordDto> getMedicalRecordByPatientOrderByDate(@PathVariable Long patientId){
        Patient patient = patientService.findPatientById(patientId);
        return medicalRecordService.findMedicalRecordByPatientOrderByDate(patient);
    }
}
