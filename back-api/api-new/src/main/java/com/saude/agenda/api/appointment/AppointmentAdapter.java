package com.saude.agenda.api.appointment;

import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.appointment.dto.AppointmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentAdapter implements Adapter<AppointmentDto, Appointment> {

    @Autowired
    private AppointmentAdapter appointmentAdapter;

    @Override
    public AppointmentDto fromEntity(Appointment appointment) {
        return new AppointmentDto(appointment.getId(),appointment.getStartTime(), appointment.getEndTime(), appointment.getDate(),
                appointment.getPerson(), appointment.getDoctor());
    }

    @Override
    public Appointment fromDto(AppointmentDto appointmentDto) {
        return new Appointment(appointmentDto.getId(), appointmentDto.getStartTime(), appointmentDto.getEndTime(),
                appointmentDto.getDate(), appointmentDto.getPerson(), appointmentDto.getDoctor());
    }
}
