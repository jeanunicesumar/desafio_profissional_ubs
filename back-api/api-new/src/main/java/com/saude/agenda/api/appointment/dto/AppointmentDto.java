package com.saude.agenda.api.appointment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saude.agenda.api.doctor.Doctor;
import com.saude.agenda.api.doctor.dto.DoctorDto;
import com.saude.agenda.api.medicalRecord.MedicalRecord;
import com.saude.agenda.api.medicalRecord.dto.MedicalRecordDto;
import com.saude.agenda.api.patient.Patient;
import com.saude.agenda.api.patient.dto.PatientDto;
import com.saude.agenda.api.person.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

    private Long id;

    @NotBlank(message = "Insira o horário inicial")
    private Timestamp startTime;

    @NotBlank(message = "Insira o horário final")
    private Timestamp endTime;

    @NotBlank(message = "Insira a data")
    private LocalDate date;

    @NotNull(message = "Insira a pessoa")
    private PatientDto patient;

    @NotNull(message = "Insira o doutor")
    private DoctorDto doctor;

    @NotNull(message = "Insira o laudo")
    private MedicalRecordDto medicalRecord;

}
