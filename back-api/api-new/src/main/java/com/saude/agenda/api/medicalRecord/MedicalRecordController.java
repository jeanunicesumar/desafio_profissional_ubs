package com.saude.agenda.api.medicalRecord;


import com.saude.agenda.api.exception.PatientNotFoundException;
import com.saude.agenda.api.medicalRecord.dto.MedicalRecordDto;
import com.saude.agenda.api.patient.Patient;
import com.saude.agenda.api.patient.PatientService;
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
    @Autowired
    private PatientService patientService;

    @GetMapping("/medicalRecord/{patientId}")
    public List<MedicalRecordDto> getMedicalRecordByPatientOrderByDate(@PathVariable Long patientId) throws PatientNotFoundException {
        try {
            Patient patient = patientService.findPatientById(patientId);
            return medicalRecordService.findMedicalRecordByPatientOrderByDate(patient);
        } catch (PatientNotFoundException e){
            throw new PatientNotFoundException();
        }
    }
}
