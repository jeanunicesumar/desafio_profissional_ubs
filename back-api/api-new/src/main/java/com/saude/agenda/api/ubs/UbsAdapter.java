package com.saude.agenda.api.ubs;

import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.address.AddressAdapter;
import com.saude.agenda.api.ubs.dto.UbsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UbsAdapter implements Adapter<UbsDto, Ubs> {

    @Autowired
    private AddressAdapter addressAdapter;

    @Override
    public UbsDto fromEntity(Ubs ubs) {
        return new UbsDto(ubs.getId(), ubs.getName(), addressAdapter.fromEntity(ubs.getAddress()));
    }

    @Override
    public Ubs fromDto(UbsDto ubsDto) {
        return new Ubs(ubsDto.getId(), ubsDto.getName(), addressAdapter.fromDto(ubsDto.getAddress()));
    }
}
