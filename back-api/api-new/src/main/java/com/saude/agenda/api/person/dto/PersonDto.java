package com.saude.agenda.api.person.dto;

import com.saude.agenda.api.address.dto.AddressDto;
import com.saude.agenda.api.person.Gender;
import com.saude.agenda.api.ubs.dto.UbsDto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Setter
public class PersonDto {

        private static final String PHONE_PATTERN_REGEX = "^\\s?9?\\d{4}-\\d{4}$";

        private Long id;

        @NotBlank(message = "Insira um nome")
        private String name;

        @NotBlank(message = "Insira o nome da mãe")
        private String motherName;

        private String fatherName;

        @NotNull(message = "Insira a data de nascimento")
        private LocalDate birthDate;

        @NotBlank(message = "Insira a cidade onde nasceu")
        private String birthCity;

        @NotBlank(message = "Insira o estado onde nasceu")
        private String birthUf;

        @NotBlank(message = "e-mail não pode ser vazio")
        @Email(message = "Insira um e-mail válido")
        private String email;

        @Enumerated(EnumType.STRING)
        private Gender gender;

        @NotBlank(message = "Insira o ddd")
        @Size(min = 2, max = 2, message = "DDD inválido")
        private String ddd;

        @NotBlank
        @Pattern(regexp = PHONE_PATTERN_REGEX, message = "Número de telefone inválido")
        private String phone;

        @NotBlank(message = "Insira um cpf")
        @CPF(message = "Cpf inválido")
        private String cpf;

        @NotBlank(message = "Insira uma senha")
        private String password;

        @NotNull
        private Boolean active;

        @NotNull(message = "Insira um endereço")
        private AddressDto address;

        @NotNull(message = "Insira uma ubs")
        private UbsDto ubs;
        
}

