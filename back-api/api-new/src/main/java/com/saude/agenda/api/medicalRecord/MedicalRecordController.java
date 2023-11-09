package com.saude.agenda.api.medicalRecord;


import com.saude.agenda.api.medicalRecord.dto.MedicalRecordDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService service;

    @GetMapping
    public ResponseEntity<Page<MedicalRecordDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.getAll(pageable));
    }

    @PostMapping
    public ResponseEntity<MedicalRecordDto> register(@RequestBody @Valid MedicalRecordDto data) {
        return ResponseEntity.ok().body(service.register(data));
    }

}
