package com.saude.agenda.api.generics.service;

import com.saude.agenda.api.generics.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;


public class CrudService<T, ID> {

    @Autowired(required = false)
    private CrudRepository<T, ID> crudRepository;

    public Page<T> findAll(Pageable pageable) {
        return crudRepository.findAll(pageable);
    }

}
