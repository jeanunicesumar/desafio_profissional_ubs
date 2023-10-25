package com.saude.agenda.api.generics.service;

import com.saude.agenda.api.generics.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class CrudService<Entity, Id> {

    @Autowired(required = false)
    private CrudRepository<Entity, Id> crudRepository;

    public Page<Entity> findAll(Pageable pageable) {
        return crudRepository.findAll(pageable);
    }

    public void save(Entity data) {
        crudRepository.save(data);
    }

    public Page<Entity> findByUbs(Long idUbs, Pageable pageable) {
        return crudRepository.findByUbs(idUbs, pageable);
    }

}
