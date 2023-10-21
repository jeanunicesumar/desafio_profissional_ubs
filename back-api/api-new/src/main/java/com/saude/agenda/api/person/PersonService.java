package com.saude.agenda.api.person;

import com.saude.agenda.api.admin.Admin;
import com.saude.agenda.api.admin.AdminAdapter;
import com.saude.agenda.api.admin.AdminRepository;
import com.saude.agenda.api.admin.AdminService;
import com.saude.agenda.api.admin.dto.AdminDto;
import com.saude.agenda.api.doctor.Doctor;
import com.saude.agenda.api.doctor.DoctorAdapter;
import com.saude.agenda.api.doctor.DoctorService;
import com.saude.agenda.api.helper.HashPassword;
import com.saude.agenda.api.person.dto.PersonLoginDto;
import com.saude.agenda.api.person.dto.ResponseDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;
    @Autowired
    private AdminRepository adminRepository;

    public ResponseDto login (PersonLoginDto data) throws Exception {
        Person person = findByCpf(data.getCpf());
        Boolean isAuth = HashPassword.verifyPassword(data.getPassword(), person.getPassword());

        if (!isAuth) {
            throw new Exception("Username or password invalid");
        }

        return new ResponseDto(person.getId(), person.getName(), person.getCpf(), person.getUbs().getId(), person.getUbs().getName(), person instanceof Doctor);

    }

    public Person findByCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }

}
