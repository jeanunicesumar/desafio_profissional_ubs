package com.saude.agenda.api.patient;


import com.saude.agenda.api.patient.dto.PatientDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {
    @Autowired
    private PatientService service;

    @GetMapping
    public List<PatientDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PatientDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<PatientDto> register(@RequestBody @Valid PatientDto data, UriComponentsBuilder uriBuilder) {
        PatientDto patient = service.register(data);
        URI location = uriBuilder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(location).body(patient);
    }
}
