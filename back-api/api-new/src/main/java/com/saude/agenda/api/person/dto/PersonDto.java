package com.saude.agenda.api.person.dto;

import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.address.dto.AddressDto;
import com.saude.agenda.api.person.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@AllArgsConstructor
@Setter
public class PersonDto {

        private Long id;

        @NotBlank
        private String name;

        @NotBlank
        private String motherName;

        @NotBlank
        private String fatherName;

        @NotNull
        private LocalDate birthDate;

        @NotBlank
        private String birthCity;

        @NotBlank
        private String birthUf;

        @NotBlank
        private String email;

        @Enumerated(EnumType.STRING)
        private Gender gender;

        @NotBlank
        private String ddd;

        @NotBlank
        private String phone;

        @NotNull
        private String cpf;

        @NotNull
        private Boolean active;

        @NotNull
        private AddressDto address;
        
}

