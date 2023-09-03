package com.saude.agenda.api.address.dto;

import com.saude.agenda.api.person.Person;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDto {

    private Long id;

    private Person person;

    @NotBlank
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
