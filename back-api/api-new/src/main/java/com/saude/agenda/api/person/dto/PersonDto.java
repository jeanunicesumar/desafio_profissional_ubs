package com.saude.agenda.api.person.dto;

import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.address.dto.AddressDto;
import com.saude.agenda.api.person.Gender;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor
@Setter
public class PersonDto {

        @NotBlank
        private Long id;

        @NotBlank
        private String name;

        @NotBlank
        private String motherName;

        @NotBlank
        private String fatherName;

        @NotNull
        private Date birthDate;

        @NotBlank
        private String birthCity;

        @NotBlank
        private String birthUf;

        @NotBlank
        private String email;

        @NotNull
        @Valid
        private Gender gender;

        @NotBlank
        private String ddd;

        @NotBlank
        private String phone;

        @NotNull
        private String cpf;

        @NotNull
        private Boolean active;

        @Valid
        private AddressDto address;
        
}

