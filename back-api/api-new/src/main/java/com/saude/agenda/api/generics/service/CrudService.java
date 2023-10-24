package com.saude.agenda.api.generics.service;

import com.saude.agenda.api.generics.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class CrudService<Domain, Id> {

    @Autowired
    private CrudRepository<Domain, Id> crudRepository;

    public Page<Domain> findAll(Pageable pageable) {
        return crudRepository.findAll(pageable);
    }

}
