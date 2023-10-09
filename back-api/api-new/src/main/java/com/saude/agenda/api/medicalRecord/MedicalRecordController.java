package com.saude.agenda.api.medicalRecord;


import com.saude.agenda.api.medicalRecord.dto.MedicalRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("medicalRecord")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService service;

    @GetMapping
    public List<MedicalRecordDto> getAll() {
        return service.getAll();
    }
}
