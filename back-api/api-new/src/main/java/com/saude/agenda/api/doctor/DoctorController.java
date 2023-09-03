package com.saude.agenda.api.doctor;

import com.saude.agenda.api.doctor.dto.DoctorDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping
    public List<DoctorDto> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return service.getAll(pageable);
    }

    @PutMapping
    public void updateDoctor(@RequestBody @Valid DoctorDto data, @PathVariable Long id){
        service.updateDoctor(data, id);
    }


}
