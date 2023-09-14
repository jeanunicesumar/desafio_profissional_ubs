package com.saude.agenda.api.patient;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findPatientById(Long patientId);
    Optional<Patient> findBySusCode(Integer susCode);
}
