package com.saude.agenda.api.generics.controller;

import com.saude.agenda.api.generics.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

public class CrudController<T, ID> {

    @Autowired(required = false)
    private CrudService<T, ID> crudService;

    @GetMapping
    public ResponseEntity<Page<T>> getAll(Pageable pageable) {
        return ResponseEntity.ok().body(crudService.findAll(pageable));
    }

}
