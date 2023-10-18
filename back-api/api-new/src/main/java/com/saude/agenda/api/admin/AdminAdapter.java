package com.saude.agenda.api.admin;

import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.address.AddressAdapter;
import com.saude.agenda.api.admin.dto.AdminDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAdapter implements Adapter<AdminDto, Admin> {

    @Autowired
    private AddressAdapter addressAdapter;

    @Override
    public AdminDto fromEntity(Admin admin) {
        return new AdminDto(admin.getId(), admin.getName(), admin.getMotherName(), admin.getFatherName(), admin.getBirthDate(), admin.getBirthCity(), admin.getBirthUf(), admin.getEmail(), admin.getGender(),
                admin.getDdd(), admin.getPhone(), admin.getCpf(), admin.getPassword(), admin.getActive(), addressAdapter.fromEntity(admin.getAddress())
        );
    }

    @Override
    public Admin fromDto(AdminDto adminDto) {
        return new Admin(adminDto.getName(), adminDto.getMotherName(), adminDto.getFatherName(), adminDto.getBirthDate(), adminDto.getBirthCity(), adminDto.getBirthUf(), adminDto.getEmail(), adminDto.getGender(),
                adminDto.getDdd(), adminDto.getPhone(), adminDto.getCpf(), adminDto.getPassword(), adminDto.getActive(), addressAdapter.fromDto(adminDto.getAddress()));
    }
}
