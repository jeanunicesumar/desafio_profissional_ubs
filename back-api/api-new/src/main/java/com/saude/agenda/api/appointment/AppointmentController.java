package com.saude.agenda.api.appointment;

import com.saude.agenda.api.appointment.dto.AppointmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping
    public List<AppointmentDto> getAll() { return service.getAll(); }
}
