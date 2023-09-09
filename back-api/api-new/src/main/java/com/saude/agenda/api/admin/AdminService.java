package com.saude.agenda.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    public List<Admin> getAll(Pageable pageable) {
        return repository.findAll();
    }
}
