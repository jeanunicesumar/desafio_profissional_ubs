package com.saude.agenda.api.appointment;

import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.appointment.dto.AppointmentDto;
import org.springframework.stereotype.Service;

@Service
public class AppointmentAdapter implements Adapter<AppointmentDto, Appointment> {

    @Override
    public AppointmentDto fromEntity(Appointment appointment) {
        return new AppointmentDto(appointment.getId(), appointment.getStartTime(), appointment.getEndTime(), appointment.getDate(),
                appointment.getPatient(), appointment.getDoctor(), appointment.getMedicalRecord());
    }

    @Override
    public Appointment fromDto(AppointmentDto appointmentDto) {
        return new Appointment(appointmentDto.getStartTime(), appointmentDto.getEndTime(),
                appointmentDto.getDate(), appointmentDto.getPatient(), appointmentDto.getDoctor(), appointmentDto.getMedicalRecord());
    }
}
