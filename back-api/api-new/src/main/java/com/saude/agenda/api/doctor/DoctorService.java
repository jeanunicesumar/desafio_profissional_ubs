package com.saude.agenda.api.doctor;

import com.saude.agenda.api.doctor.dto.DoctorDto;
<<<<<<< HEAD
=======
import jakarta.validation.Valid;
>>>>>>> 5565c4f2c4e5cec8a711cd5c0f37af2057511613
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

<<<<<<< HEAD
    @Autowired
    private DoctorAdapter adapter;

    public List<DoctorDto> getAll() {
        return repository.findAll().stream().map(this::getDoctorDto).toList();
    }

    public DoctorDto getDoctorDto(Doctor doctor) {
        return adapter.fromEntity(doctor);
    }

    public DoctorDto register(DoctorDto data) {
        Doctor doctor = adapter.fromDto(data);
        repository.save(doctor);
        return adapter.fromEntity(doctor);
=======
    public List<DoctorDto> getAll(Pageable pageable) {
        return repository.findAll();
    }

    public void updateDoctor(@RequestBody @Valid DoctorDto data, @PathVariable Long id) {
        var findDoctor = repository.getReferenceById(id);
        findDoctor.updateRegister(data);
>>>>>>> 5565c4f2c4e5cec8a711cd5c0f37af2057511613
    }
}
