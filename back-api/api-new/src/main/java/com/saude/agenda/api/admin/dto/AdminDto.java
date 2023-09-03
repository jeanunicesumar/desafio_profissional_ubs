package com.saude.agenda.api.admin.dto;

import com.saude.agenda.api.address.dto.AddressDto;
import com.saude.agenda.api.person.Gender;
import com.saude.agenda.api.person.dto.PersonDto;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class AdminDto extends PersonDto {
   public AdminDto (@Valid Long id, @Valid String name, @Valid String motherName,
                    @Valid String fatherName, @Valid Date birthDate, @Valid String birthCity,
                    @Valid String birthUf, @Valid String email, @Valid Gender gender,
                    @Valid String ddd, @Valid String phone, @Valid String cpf,
                    @Valid Boolean active, @Valid AddressDto address){
       super(id, name, motherName, fatherName, birthDate, birthCity, birthUf, email, gender, ddd, phone, cpf, active, address);
   }
}
