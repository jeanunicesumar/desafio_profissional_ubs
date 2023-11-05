package com.saude.agenda.api.appointment;

import com.saude.agenda.api.appointment.dto.AppointmentDto;
import com.saude.agenda.api.doctor.Doctor;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private AppointmentAdapter adapter;

    public Page<AppointmentDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::getAppointmentDto);
    }

    public AppointmentDto getAppointmentDto(Appointment appointment) {
        return adapter.fromEntity(appointment);
    }

    public List<AppointmentDto> getTodayAppointment(LocalDate date){
        LocalDate actualDate = LocalDate.now();
        if(date.isEqual(actualDate)){
            List<Appointment> consultas = repository.findByDate(actualDate);
            return consultas.stream().map(this::getAppointmentDto).collect(Collectors.toList());
        } else
            return Collections.emptyList();
    }

    public AppointmentDto register(AppointmentDto data) {
        Appointment appointment = adapter.fromDto(data);
        repository.save(appointment);
        return adapter.fromEntity(appointment);
    }

    public AppointmentDto getById(Long id) {
        Appointment appointment = findById(id);
        return adapter.fromEntity(appointment);
    }

    public Page<AppointmentDto> getByDoctor(Long id, Pageable pageable) {
        return findByDoctor(id, pageable).map(this::getAppointmentDto);
    }

    public Page<AppointmentDto> getByPatient(Long id, Pageable pageable) {
        return findByPatient(id, pageable).map(this::getAppointmentDto);
    }

    private Appointment findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Appointment not found"));
    }

    private Page<Appointment> findByDoctor(Long id, Pageable pageable) {
        return repository.findByDoctor(id, pageable).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
    }

    private Page<Appointment> findByPatient(Long id, Pageable pageable) {
        return repository.findByPatient(id, pageable).orElseThrow(() -> new EntityNotFoundException("Patient not found"));
    }

    public AppointmentDto remark(LocalDate data, Long id) throws Exception {
        Appointment appointment = findById(id);
        verifyDate(data, appointment.getDate());
        appointment.setDate(data);
        repository.save(appointment);
        return adapter.fromEntity(appointment);
    }

    private void verifyDate(LocalDate dateRemark, LocalDate dateAppointment) throws Exception {
        LocalDate date = dateAppointment.minusDays(7);
        if(dateRemark.isAfter(date)) {
            throw new Exception("Data para reagendamento inválida");
        }
    }

}
