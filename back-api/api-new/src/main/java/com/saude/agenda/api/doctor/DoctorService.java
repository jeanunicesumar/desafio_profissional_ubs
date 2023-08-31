package com.saude.agenda.api.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.awt.print.Pageable;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public List<Doctor> getAll(Pageable pageable) {
        return repository.findAll();
    }

}
