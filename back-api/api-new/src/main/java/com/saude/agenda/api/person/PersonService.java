package com.saude.agenda.api.person;

import com.saude.agenda.api.doctor.Doctor;
import com.saude.agenda.api.doctor.dto.DoctorDto;
import com.saude.agenda.api.doctor.dto.DoctorLoginDto;
import com.saude.agenda.api.helper.HashPassword;
import com.saude.agenda.api.person.dto.PersonLoginDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    // TODO: Adapter

    public Person login (PersonLoginDto data) throws Exception {
        Person person = findByCpf(data.getCpf());
        Boolean isLogin = HashPassword.verifyPassword(data.getPassword(), data.getPassword());

        if (isLogin) {
            return person;
        }

        throw new Exception("Username or password invalid");
    }

    public Person findByCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(() -> new EntityNotFoundException("Person not found"));
    }

}
