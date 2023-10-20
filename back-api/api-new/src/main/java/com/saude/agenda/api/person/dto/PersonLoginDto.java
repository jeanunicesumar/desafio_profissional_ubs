package com.saude.agenda.api.person.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
public class PersonLoginDto {

    @NotBlank(message = "Insira o cpf")
    @CPF(message = "Insira um cpf válido")
    private String cpf;

    @NotBlank(message = "Insira uma senha")
    private String password;

}
