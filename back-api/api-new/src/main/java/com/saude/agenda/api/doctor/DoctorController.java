package com.saude.agenda.api.doctor;

import com.saude.agenda.api.doctor.dto.DoctorDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;
=======
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
>>>>>>> 5565c4f2c4e5cec8a711cd5c0f37af2057511613

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping
<<<<<<< HEAD
    public List<DoctorDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<DoctorDto> register(@RequestBody @Valid DoctorDto data, UriComponentsBuilder uriBuilder) {
        DoctorDto doctor = service.register(data);
        URI location = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(location).body(doctor);
=======
    public List<DoctorDto> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return service.getAll(pageable);
>>>>>>> 5565c4f2c4e5cec8a711cd5c0f37af2057511613
    }

    @PutMapping
    public void updateDoctor(@RequestBody @Valid DoctorDto data, @PathVariable Long id){
        service.updateDoctor(data, id);
    }


}
