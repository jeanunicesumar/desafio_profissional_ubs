package saude.agenda.api.doctor;

import jakarta.validation.constraints.NotNull;


public record DoctorRegister( //DTO para registro dos médicos
        @NotNull
        String crm,

        @NotNull
        Specialty specialty

) {
}
