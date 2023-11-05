package com.saude.agenda.api.appointment;

import com.saude.agenda.api.appointment.dto.AppointmentDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping
    public ResponseEntity<Page<AppointmentDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getById(id));
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Page<AppointmentDto>> getByDoctor(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok().body(service.getByDoctor(id, pageable));
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Page<AppointmentDto>> getByPatient(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok().body(service.getByPatient(id, pageable));
    }

    @GetMapping("/today")
    public List<AppointmentDto> getTodayAppointments(){
        LocalDate actualDate = LocalDate.now();
        return service.getTodayAppointment(actualDate);
    }

    @PostMapping
    public AppointmentDto register(@RequestBody @Valid AppointmentDto data) {
        return service.register(data);
    }

    @PutMapping("/remark/{id}")
    public AppointmentDto remark(@RequestBody LocalDate data, @PathVariable Long id) throws Exception {
        return service.remark(data, id);
    }


}
