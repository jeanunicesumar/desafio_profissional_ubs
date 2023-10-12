package com.saude.agenda.api.patient;


import com.saude.agenda.api.patient.dto.PatientDto;
import com.saude.agenda.api.patient.dto.PatientLoginDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService service;

    @GetMapping
    public ResponseEntity<Page<PatientDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<PatientDto> register(@RequestBody @Valid PatientDto data, UriComponentsBuilder uriBuilder) {
        PatientDto patient = service.register(data);
        URI location = uriBuilder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(location).body(patient);
    }

    @GetMapping("/auth")
    public ResponseEntity<PatientDto> login(@RequestBody @Valid PatientLoginDto data) throws Exception {
        return ResponseEntity.ok(service.login(data));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
