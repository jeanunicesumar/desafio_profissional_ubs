package com.saude.agenda.api.doctor.dto;

import com.saude.agenda.api.person.dto.PersonDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DoctorDto {

    private Long id;

    @NotNull
    private Integer crm;

    @NotNull
    private PersonDto person;

    public DoctorDto(Long id, @NotNull Integer crm, @Valid PersonDto person) {
        this.id = id;
        this.crm = crm;
        this.person = person;
    }
}
