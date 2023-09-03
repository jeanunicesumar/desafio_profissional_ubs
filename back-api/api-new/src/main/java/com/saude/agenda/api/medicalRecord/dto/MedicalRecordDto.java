package com.saude.agenda.api.medicalRecord.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalRecordDto {
    @NotBlank
    private Long id;
    private String description;

    public MedicalRecordDto (@NotBlank Long id, String description){
        this.id = id;
        this.description = description;
    }

}
