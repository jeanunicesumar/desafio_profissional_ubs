package com.saude.agenda.api.admin.dto;

import com.saude.agenda.api.address.dto.AddressDto;
import com.saude.agenda.api.person.Gender;
import com.saude.agenda.api.person.dto.PersonDto;
import com.saude.agenda.api.ubs.dto.UbsDto;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AdminDto extends PersonDto {

    public AdminDto(Long id, @Valid String name, @Valid String motherName,
                    String fatherName, @Valid LocalDate birthDate, @Valid String birthCity,
                    @Valid String birthUf, @Valid String email, @Valid Gender gender,
                    @Valid String ddd, @Valid String phone, @Valid String cpf, @Valid String password,
                    @Valid Boolean active, @Valid AddressDto address, @Valid UbsDto ubs) {
        super(id, name, motherName, fatherName, birthDate, birthCity, birthUf, email, gender, ddd, phone, cpf, password, active, address, ubs);
    }
}
