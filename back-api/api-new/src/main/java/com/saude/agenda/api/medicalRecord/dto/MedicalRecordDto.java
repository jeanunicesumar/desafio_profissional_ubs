package com.saude.agenda.api.medicalRecord.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicalRecordDto {

    private Long id;

    @NotBlank
    private String description;

    private LocalDate date;

}
