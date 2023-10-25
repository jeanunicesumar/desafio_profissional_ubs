package com.saude.agenda.api.person;

import com.saude.agenda.api.admin.AdminService;
import com.saude.agenda.api.doctor.DoctorService;
import com.saude.agenda.api.generics.repository.CrudRepository;
import com.saude.agenda.api.generics.service.CrudService;
import com.saude.agenda.api.helper.HashPassword;
import com.saude.agenda.api.person.dto.PersonLoginDto;
import com.saude.agenda.api.person.dto.ResponseDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AdminService adminService;

    public ResponseDto login (PersonLoginDto data) throws Exception {
        Person person = findByCpf(data.getCpf());
        Boolean isAuth = HashPassword.verifyPassword(data.getPassword(), person.getPassword());

        if (!isAuth) {
            throw new EntityNotFoundException("Password invalid");
        }

        return new ResponseDto(person.getId(), person.getName(), person.getCpf(), person.getUbs().getId(),
                person.getUbs().getName(), doctorService.exists(person.getId()), adminService.exists(person.getId()));

    }

    public Person findByCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }

}
