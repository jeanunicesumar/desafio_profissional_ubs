package saude.agenda.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressRegister(
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zip_code,

        @NotBlank
        String street_address,

        String street_address_II,

        @NotBlank
        String house_number,

        @NotBlank
        String city,

        @NotBlank
        String district,

        @NotBlank
        String state
) {

}
