package com.saude.agenda.api.appointment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Page<Appointment>> findByDoctor(Long id, Pageable pageable);

    Optional<Page<Appointment>> findByPatient(Long id, Pageable pageable);

    List<Appointment> findByDate(LocalDate actualDate);
}
