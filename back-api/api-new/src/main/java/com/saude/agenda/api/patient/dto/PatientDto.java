package com.saude.agenda.api.patient.dto;

import com.saude.agenda.api.person.dto.PersonDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDto {

    private Long id;

    @NotNull
    private Integer susCode;

    @NotNull
    private PersonDto person;

    public PatientDto(Long id, Integer susCode, @Valid PersonDto person) {
        this.id = id;
        this.susCode = susCode;
        this.person = person;
    }

}
