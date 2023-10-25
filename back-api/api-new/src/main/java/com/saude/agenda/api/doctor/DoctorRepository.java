package com.saude.agenda.api.doctor;

import com.saude.agenda.api.generics.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    Optional<Doctor> findByCrm(Integer crm);

    Boolean existsByPersonId(Long personId);
}
