package com.saude.agenda.api.admin;

import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.address.AddressAdapter;
import com.saude.agenda.api.admin.dto.AdminDto;
import com.saude.agenda.api.person.PersonAdapter;
import com.saude.agenda.api.ubs.Ubs;
import com.saude.agenda.api.ubs.UbsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAdapter implements Adapter<AdminDto, Admin> {

    @Autowired
    private PersonAdapter personAdapter;

    @Override
    public AdminDto fromEntity(Admin admin) {
        return new AdminDto(admin.getId(), personAdapter.fromEntity(admin.getPerson()));
    }

    @Override
    public Admin fromDto(AdminDto adminDto) {
        return new Admin();
    }
}
