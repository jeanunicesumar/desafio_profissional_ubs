package com.saude.agenda.api.doctor;

import com.saude.agenda.api.doctor.dto.DoctorDto;
import com.saude.agenda.api.helper.HashPassword;
import com.saude.agenda.api.person.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private PersonRepository doctorRepository;

    @Autowired
    private DoctorAdapter adapter;

    public Page<DoctorDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::getDoctorDto);
    }

    private DoctorDto getDoctorDto(Doctor doctor) {
        return adapter.fromEntity(doctor);
    }

    public DoctorDto register(DoctorDto data) {
        data.getPerson().setPassword(HashPassword.generateHash(data.getPerson().getPassword()));
        Doctor doctor = adapter.fromDto(data);
        repository.save(doctor);
        return adapter.fromEntity(doctor);
    }

    public DoctorDto getById(Long id) {
        Doctor doctor = findById(id);
        return adapter.fromEntity(doctor);
    }

    public void updateDoctor(@RequestBody @Valid DoctorDto data, @PathVariable Long id) {
        var findDoctor = repository.getReferenceById(id);
//        findDoctor.updateRegister(data);
    }

    public void deleteById(Long id) {
        Doctor doctor = findById(id);
        doctor.getPerson().setActive(false);
        repository.save(doctor);
    }

    private Doctor findByCrm(Integer crm) {
        return repository.findByCrm(crm).
                orElseThrow(() -> new EntityNotFoundException("CRM ou senha inválidos"));
    }

    private Doctor findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
    }

    public Boolean exists(@PathVariable Long id) {
        return doctorRepository.existsById(id);
    }

}
