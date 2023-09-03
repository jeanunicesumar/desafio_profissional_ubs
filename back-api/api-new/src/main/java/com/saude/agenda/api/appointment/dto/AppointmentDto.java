package com.saude.agenda.api.appointment.dto;

import com.saude.agenda.api.doctor.Doctor;
import com.saude.agenda.api.person.Person;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor

public class AppointmentDto {
    private Long id;

    @NotBlank
    private Timestamp startTime;

    @NotBlank
    private Timestamp endTime;

    @NotBlank
    private Date date;

    @NotBlank
    private Person person;

    @NotBlank
    private Doctor doctor;
}
