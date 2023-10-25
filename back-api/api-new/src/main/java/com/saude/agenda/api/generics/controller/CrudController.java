package com.saude.agenda.api.generics.controller;

import com.saude.agenda.api.generics.service.CrudService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CrudController<Entity, Id> {

    @Autowired(required = false)
    private CrudService<Entity, Id> crudService;

    @GetMapping
    public ResponseEntity<Page<Entity>> getAll(Pageable pageable) {
        return ResponseEntity.ok().body(crudService.findAll(pageable));
    }

    @PostMapping
    @Transactional
    public void save(@RequestBody Entity data) {
        crudService.save(data);
    }

    @GetMapping("/ubs/{id}")
    public ResponseEntity<Page<Entity>> getByUbsId(@PathVariable Long id, Pageable pageable) {
        return ResponseEntity.ok().body(crudService.findByUbs(id, pageable));
    }

}
