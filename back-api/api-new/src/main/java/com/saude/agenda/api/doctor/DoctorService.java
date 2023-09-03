package com.saude.agenda.api.doctor;

import com.saude.agenda.api.doctor.dto.DoctorDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.print.Doc;
import java.awt.print.Pageable;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public List<DoctorDto> getAll(Pageable pageable) {
        return repository.findAll();
    }

    public void updateDoctor(@RequestBody @Valid DoctorDto data, @PathVariable Long id) {
        var findDoctor = repository.getReferenceById(id);
        findDoctor.updateRegister(data);
    }
}
