package com.saude.agenda.api.generics.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface CrudRepository<Entity, Id> extends JpaRepository<Entity, Id> {

    @Query(value = "SELECT e FROM #{#entityName} e " +
            "INNER JOIN e.person p " +
            "WHERE p.ubs.id = :idUbs")
    Page<Entity> findByUbs(@Param("idUbs") Long idubs, Pageable pageable);

}
