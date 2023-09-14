package com.saude.agenda.api.admin;

import com.saude.agenda.api.admin.dto.AdminDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    @Autowired
    private AdminAdapter adapter;

    public List<Admin> getAll(Pageable pageable) {
        return repository.findAll();
    }

    private AdminDto getAdminDto(Admin admin) {
        return adapter.fromEntity(admin);
    }

    public AdminDto register(AdminDto data) {
        Admin admin = adapter.fromDto(data);
        repository.save(admin);
        return adapter.fromEntity(admin);
    }

    public AdminDto getById(Long id) {
        Admin admin = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));
        return adapter.fromEntity(admin);
    }

    // update
}
