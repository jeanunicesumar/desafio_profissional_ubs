package saude.agenda.api.doctor.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import saude.agenda.api.person.Gender;
import saude.agenda.api.person.dto.PersonDto;

import java.util.Date;

@Getter
public class DoctorDto extends PersonDto {

    @NotBlank
    private Integer susCode;

    public DoctorDto(@NotBlank Integer susCode, @NotBlank Long id, @NotBlank String name, @NotBlank String motherName,
                     @NotBlank String fatherName, @NotNull Date birthDate, @NotBlank String email,
                     @NotNull @Valid Gender gender, @NotBlank String ddd, @NotBlank String phone, @NotNull String cpf) {
        super(id, name, motherName, fatherName, birthDate, email, gender, ddd, phone, cpf);
        this.susCode = susCode;
    }
}
