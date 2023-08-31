package saude.agenda.api.person.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import saude.agenda.api.person.Gender;

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

//        @NotBlank
//        String birthCity;
//
//        @NotBlank
//        String birthUf;

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

//        @NotNull
//        @Valid
//        AddressRegister address
}
