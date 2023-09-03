package com.saude.agenda.api.appointment;

import com.saude.agenda.api.appointment.dto.AppointmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private AppointmentAdapter adapter;

    public List<AppointmentDto> getAll() { return repository.findAll().stream().map(this::getAppointmentDto).toList();}

    public AppointmentDto getAppointmentDto(Appointment appointment) { return adapter.fromEntity(appointment); }

    public AppointmentDto register(AppointmentDto data) {
        Appointment appointment = adapter.fromDto(data);
        repository.save(appointment);
        return adapter.fromEntity(appointment);
    }
}
