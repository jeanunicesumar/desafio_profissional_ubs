package com.saude.agenda.api.address.dto;

import com.saude.agenda.api.person.Person;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    @NotBlank
    private Long id;

    @NotBlank
    private Person person;

    @NotBlank
    private String zipCode;

    @NotBlank
    private String streetAddress;

    @NotBlank
    private String streetAddressII;

    @NotBlank
    private String number;

    @NotBlank
    private String district;

    @NotBlank
    private String city;

    @NotBlank
    private String uf;

    public AddressDto(Long id, String zipCode, String streetAddress,
                      String streetAddressII, String number, String district,
                      String city, String uf) {
        this.id = id;
        this.streetAddress = streetAddress;
        this.streetAddressII = streetAddressII;
        this.number = number;
        this.district = district;
        this.city = city;
        this.uf = uf;
    }
}
