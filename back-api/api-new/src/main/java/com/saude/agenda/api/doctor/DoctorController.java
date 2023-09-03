package com.saude.agenda.api.doctor;

import com.saude.agenda.api.doctor.dto.DoctorDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping
    public List<DoctorDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<DoctorDto> register(@RequestBody @Valid DoctorDto data, UriComponentsBuilder uriBuilder) {
        DoctorDto doctor = service.register(data);
        URI location = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(location).body(doctor);
    }

}
