package com.saude.agenda.api.doctor.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class DoctorLoginDto {

    @NotBlank(message = "Insira o CRM")
    private Integer crm;

    @NotBlank(message = "Insira sua senha")
    private String password;
}
