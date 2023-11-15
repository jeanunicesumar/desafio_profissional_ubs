package com.saude.agenda.api.admin.dto;

import com.saude.agenda.api.address.dto.AddressDto;
import com.saude.agenda.api.person.Gender;
import com.saude.agenda.api.person.dto.PersonDto;
import com.saude.agenda.api.ubs.dto.UbsDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.lang.management.LockInfo;
import java.time.LocalDate;

@Getter
@Setter
public class AdminDto {

    private Long id;

    @NotNull
    private PersonDto person;

    public AdminDto(Long id, @Valid PersonDto person) {
        this.id = id;
        this.person = person;
    }

    public AdminDto() {

    }
}
