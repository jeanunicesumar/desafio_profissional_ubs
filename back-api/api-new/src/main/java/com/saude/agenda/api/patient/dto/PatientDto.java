package com.saude.agenda.api.patient.dto;

import com.saude.agenda.api.address.dto.AddressDto;
import com.saude.agenda.api.person.Gender;
import com.saude.agenda.api.person.dto.PersonDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PatientDto extends PersonDto {

    @NotNull
    private Integer susCode;

    public PatientDto (
            Integer susCode, @Valid Long id, @Valid String name, @Valid String motherName,
            @Valid String fatherName, @Valid LocalDate birthDate, @Valid String birthCity,
            @Valid String birthUf, @Valid String email, @Valid Gender gender,
            @Valid String ddd, @Valid String phone, @Valid String cpf, @Valid String password,
            @Valid Boolean active, @Valid AddressDto address) {
        super(id, name, motherName, fatherName, birthDate, birthCity, birthUf, email, gender, ddd, phone, cpf, password, active, address);
        this.susCode = susCode;
    }

}
