package saude.agenda.api.doctor;


import jakarta.validation.constraints.NotNull;
import saude.agenda.api.address.AddressRegister;

// DTO para atualização dos dados do médico
public record DoctorUpdate(
        @NotNull
        Long id,
        String phone,
        AddressRegister address) {
}
