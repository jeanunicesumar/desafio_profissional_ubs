package com.saude.agenda.api.medicalRecord.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MedicalRecordDto {
    @NotBlank
    private Long id;
    private String description;
    private Date medicalRecordDate;

    public MedicalRecordDto (@NotBlank Long id, String description, Date medicalRecordDate){
        this.id = id;
        this.description = description;
        this.medicalRecordDate = medicalRecordDate;
    }

}
