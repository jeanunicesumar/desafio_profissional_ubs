package com.saude.agenda.api.appointment.dto;

import com.saude.agenda.api.doctor.Doctor;
import com.saude.agenda.api.medicalRecord.MedicalRecord;
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

    @NotBlank(message = "Insira o horário inicial")
    private Timestamp startTime;

    @NotBlank(message = "Insira o horário final")
    private Timestamp endTime;

    @NotBlank(message = "Insira a data")
    private Date date;

    @NotBlank(message = "Insira a pessoa")
    private Person person;

    @NotBlank(message = "Insira o doutor")
    private Doctor doctor;

    private MedicalRecord medicalRecord;

}
