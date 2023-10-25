package com.saude.agenda.api.generics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface CrudRepository<T, ID> extends JpaRepository<T, ID> { }
