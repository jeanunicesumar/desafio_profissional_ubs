package com.saude.agenda.api.doctor;

import com.saude.agenda.api.doctor.dto.DoctorDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<DoctorDto> save(@RequestBody @Valid DoctorDto data) {
        return ResponseEntity.ok().body(service.save(data));
    }


}
