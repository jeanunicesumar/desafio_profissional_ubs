package com.saude.agenda.api.person;

import com.saude.agenda.api.admin.Admin;
import com.saude.agenda.api.generics.controller.CrudController;
import com.saude.agenda.api.person.dto.PersonLoginDto;
import com.saude.agenda.api.person.dto.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController extends CrudController<Person, Long> {

    @Autowired
    private PersonService service;

    @PostMapping("/auth")
    public ResponseEntity<ResponseDto> auth(@RequestBody @Valid PersonLoginDto data) throws Exception {
        return  ResponseEntity.ok().body(service.login(data));
    }

}
