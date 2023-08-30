package saude.agenda.api.person;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import saude.agenda.api.address.AddressRegister;

import java.util.Date;

public record PersonRegister( //DTO para registro da PESSOA
        @NotBlank
        String fullName,

        @NotBlank
        String motherName,

        @NotBlank
        String fatherName,

        @NotNull
        Date birthDate,

        @NotBlank
        String birthCity,

        @NotBlank
        String birthUf,

        @NotNull
        @Valid
        Gender gender,

        @NotBlank
        String ddd,

        @NotBlank
        String phone,

        @NotNull
        String cpf,

        @NotNull
        @Valid
        AddressRegister address
) {

}
