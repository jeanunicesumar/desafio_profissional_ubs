package com.saude.agenda.api.person;

import com.saude.agenda.api.generics.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByCpf(String cpf);

}
