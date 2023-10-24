package com.saude.agenda.api.person;

import com.saude.agenda.api.generics.repository.CrudRepository;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Id> {

    Optional<Person> findByCpf(String cpf);

}
