package com.saude.agenda.api.patient;

import com.saude.agenda.api.patient.dto.PatientDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientDto, Long> {
}
