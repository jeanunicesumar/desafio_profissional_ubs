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

public class PatientUpdateDto {

    @NotBlank(message = "Insira o novo e-mail")
    private String email;

    @NotBlank(message = "Insira o novo telefone")
    private String phone;

}
