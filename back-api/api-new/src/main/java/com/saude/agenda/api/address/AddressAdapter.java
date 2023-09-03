package com.saude.agenda.api.address;

import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.address.dto.AddressDto;
import org.springframework.stereotype.Service;


@Service
public class AddressAdapter implements Adapter<AddressDto, Address> {


    @Override
    public AddressDto fromEntity(Address address) {
        return new AddressDto(address.getId(), address.getZipCode(), address.getStreetAddress(),
                address.getStreetAddressII(), address.getNumber(), address.getDistrict(), address.getCity(),
                address.getUf());
    }

    @Override
    public Address fromDto(AddressDto addressDto) {
        return new Address(addressDto.getZipCode(), addressDto.getStreetAddress(),
                addressDto.getStreetAddressII(), addressDto.getNumber(), addressDto.getDistrict(),
                addressDto.getCity(), addressDto.getUf());
    }
}
