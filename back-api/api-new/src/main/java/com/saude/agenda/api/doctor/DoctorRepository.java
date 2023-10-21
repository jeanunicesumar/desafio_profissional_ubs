package com.saude.agenda.api.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByCrm(Integer crm);

    Boolean existsByPersonId(Long personId);
}
