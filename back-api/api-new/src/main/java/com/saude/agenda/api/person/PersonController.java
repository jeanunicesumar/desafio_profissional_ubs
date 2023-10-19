package com.saude.agenda.api.person;

import com.saude.agenda.api.doctor.dto.DoctorDto;
import com.saude.agenda.api.doctor.dto.DoctorLoginDto;
import com.saude.agenda.api.person.dto.PersonDto;
import com.saude.agenda.api.person.dto.PersonLoginDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping("/auth")
    public ResponseEntity<Person> auth(@RequestBody @Valid PersonLoginDto data) throws Exception {
        return ResponseEntity.ok(service.login(data));
    }

}