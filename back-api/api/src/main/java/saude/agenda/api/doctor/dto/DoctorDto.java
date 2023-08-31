package saude.agenda.api.doctor.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import saude.agenda.api.person.dto.PersonDto;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    @NotBlank
    private Long id;

    @NotBlank
    private int susCode;

    @NotBlank
    private PersonDto personDto;

}
