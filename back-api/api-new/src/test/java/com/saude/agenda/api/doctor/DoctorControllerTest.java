package com.saude.agenda.api.doctor;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.PageRequest;

import javax.print.Doc;

import java.awt.print.Pageable;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DoctorControllerTest {

    @InjectMocks
    private DoctorRepository repository;

    @Mock
    private DoctorService service;

    private Doctor doctor;

//    @BeforeEach
//    public void setUp() {
//        doctor = new Doctor(123, 1, "carlos", "maria", "joao", Date);
//    }

    public void should_return_status_ok_when_get_all_doctor() {
        Pageable pageable = (Pageable) PageRequest.of(0, 8);
//        Mockito.when(service.getAll(pageable)).thenReturn()

        service.getAll(pageable);

    }

}