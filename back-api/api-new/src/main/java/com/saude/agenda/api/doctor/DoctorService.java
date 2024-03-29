package com.saude.agenda.api.doctor;

import com.saude.agenda.api.doctor.dto.DoctorDto;
import com.saude.agenda.api.doctor.dto.DoctorLoginDto;
import com.saude.agenda.api.helper.HashPassword;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private DoctorAdapter adapter;

    public Page<DoctorDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::getDoctorDto);
    }

    private DoctorDto getDoctorDto(Doctor doctor) {
        return adapter.fromEntity(doctor);
    }

    public DoctorDto register(DoctorDto data) {
        data.setPassword(HashPassword.generateHash(data.getPassword()));
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
        doctor.setActive(false);
        repository.save(doctor);
    }

    public DoctorDto login (DoctorLoginDto data) throws Exception {
        Doctor doctor = findByCrm(data.getCrm());
        Boolean isLogin = HashPassword.verifyPassword(data.getPassword(), doctor.getPassword());

        if (isLogin) {
            return adapter.fromEntity(doctor);
        }

        throw new Exception("Username or password invalid");
    }

    private Doctor findByCrm(Integer crm) {
        return repository.findByCrm(crm).
                orElseThrow(() -> new EntityNotFoundException("CRM ou senha inválidos"));
    }

    private Doctor findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
    }
}
