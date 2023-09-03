package com.saude.agenda.api.address.dto;

import com.saude.agenda.api.person.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDto {

    private static final String ZIP_CODE_PATTERN_REGEX = "^\\d{5}-\\d{3}$";

    private Long id;

    private Person person;

    @NotBlank
    @Pattern(regexp = ZIP_CODE_PATTERN_REGEX)
    private String zipCode;

    @NotBlank
    private String streetAddress;

    private String streetAddressII;

    @NotBlank
    private String number;

    @NotBlank
    private String district;

    @NotBlank
    private String city;

    @NotBlank
    @Size(min = 2, max = 2)
    private String uf;


    public AddressDto(Long id, String zipCode, String streetAddress, String streetAddressII, String number, String district, String city, String uf) {
        this.id = id;
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
        this.streetAddressII = streetAddressII;
        this.number = number;
        this.district = district;
        this.city = city;
        this.uf = uf;
    }

}
