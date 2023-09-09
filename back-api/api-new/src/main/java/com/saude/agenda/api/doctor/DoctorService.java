package com.saude.agenda.api.doctor;

import com.saude.agenda.api.doctor.dto.DoctorDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private DoctorAdapter adapter;

    public List<DoctorDto> getAll() {
        return repository.findAll().stream().map(this::getDoctorDto).toList();
    }

    private DoctorDto getDoctorDto(Doctor doctor) {
        return adapter.fromEntity(doctor);
    }

    public DoctorDto register(DoctorDto data) {
        Doctor doctor = adapter.fromDto(data);
        repository.save(doctor);
        return adapter.fromEntity(doctor);
    }

    public DoctorDto getById(Long id) {
        Doctor doctor = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
        return adapter.fromEntity(doctor);
    }

    public void updateDoctor(@RequestBody @Valid DoctorDto data, @PathVariable Long id) {
        var findDoctor = repository.getReferenceById(id);
//        findDoctor.updateRegister(data);
    }
}
