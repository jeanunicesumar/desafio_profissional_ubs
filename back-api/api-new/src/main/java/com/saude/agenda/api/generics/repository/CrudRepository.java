package com.saude.agenda.api.generics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CrudRepository<Domain, Id> extends JpaRepository<Domain, Id> { }
