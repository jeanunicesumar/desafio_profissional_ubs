package com.saude.agenda.api.patient.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class PatientLoginDto {

        @NotBlank(message = "Insira o número do SUS")
        private Integer susCode;

        @NotBlank(message = "Insira sua senha")
        private String password;

}
