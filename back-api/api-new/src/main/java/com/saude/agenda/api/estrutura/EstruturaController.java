package com.saude.agenda.api.estrutura;

import com.saude.agenda.api.appointment.dto.AppointmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estrutura")
public class EstruturaController {

    @Autowired
    private EstruturaService service;

    @GetMapping
    public List<AppointmentDto> getAppointment() {
        return service.getAppointment();
    }

}
