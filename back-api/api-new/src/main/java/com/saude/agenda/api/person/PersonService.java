package com.saude.agenda.api.person;

import com.saude.agenda.api.admin.Admin;
import com.saude.agenda.api.admin.AdminAdapter;
import com.saude.agenda.api.admin.AdminService;
import com.saude.agenda.api.admin.dto.AdminDto;
import com.saude.agenda.api.doctor.DoctorAdapter;
import com.saude.agenda.api.doctor.DoctorService;
import com.saude.agenda.api.helper.HashPassword;
import com.saude.agenda.api.person.dto.PersonLoginDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private AdminService adminService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AdminAdapter adminAdapter;

    @Autowired
    private DoctorAdapter doctorAdapter;

    public Person login (PersonLoginDto data) throws Exception {
        Person person = findByCpf(data.getCpf());
        Boolean isAuth = HashPassword.verifyPassword(data.getPassword(), data.getPassword());

        if (!isAuth) {
            throw new Exception("Username or password invalid");
        }

        Admin admin = adminAdapter.fromDto(adminService.getById(person.getId()));

        if (Objects.nonNull(admin)) {
            return admin;
        }

        return doctorAdapter.fromDto(doctorService.getById(person.getId()));

    }

    public Person findByCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }

}
