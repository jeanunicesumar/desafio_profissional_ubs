package com.saude.agenda.api.doctor.dto;

import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.address.dto.AddressDto;
import com.saude.agenda.api.person.Gender;
import com.saude.agenda.api.person.dto.PersonDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DoctorDto extends PersonDto {

    @NotBlank
    private Long crm;


    public DoctorDto(@NotBlank Long crm, @NotBlank Long id, @NotBlank String name, @NotBlank String motherName,
                     @NotBlank String fatherName, @NotNull Date birthDate, @NotBlank String birthCity,
                     @NotBlank String birthUf, @NotBlank String email, @NotNull @Valid Gender gender,
                     @NotBlank String ddd, @NotBlank String phone, @NotNull String cpf,
                     @NotNull Long active, @Valid Address address) {
        super(id, name, motherName, fatherName, birthDate, birthCity, birthUf, email, gender, ddd, phone, cpf, active, address);
        this.crm = crm;
    }
}
