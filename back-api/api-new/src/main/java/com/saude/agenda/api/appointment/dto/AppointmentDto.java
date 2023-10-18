package com.saude.agenda.api.appointment.dto;

import com.saude.agenda.api.doctor.Doctor;
import com.saude.agenda.api.medicalRecord.MedicalRecord;
import com.saude.agenda.api.patient.Patient;
import com.saude.agenda.api.person.Person;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

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
    private LocalDate date;

    @NotBlank(message = "Insira a pessoa")
    private Patient patient;

    @NotBlank(message = "Insira o doutor")
    private Doctor doctor;

    @NotBlank(message = "Insira o laudo")
    private MedicalRecord medicalRecord;

}
