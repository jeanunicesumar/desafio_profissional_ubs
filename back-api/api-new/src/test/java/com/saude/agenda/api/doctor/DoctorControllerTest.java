package com.saude.agenda.api.doctor;

import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.person.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class DoctorControllerTest {

    @Mock
    private DoctorRepository repository;

    @InjectMocks
    private DoctorService service;

    @InjectMocks
    private DoctorAdapter adapter;

    private Doctor doctor;
    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address("87230-230", "Rua Tal", "Complemento", "123A", "Bairro tal", "Maringá", "PR");
        doctor = new Doctor(1231231, "carlos", "maria", "joao", LocalDate.of(2020, 1, 8), "Maringá", "PR", "teste@gmail.com",
                Gender.MASCULINO, "44", "99999-9999", "123.456.789-10", true, address);
    }

    @Test
    public void should_return_status_ok_when_get_all_doctor() {
        Pageable pageable = PageRequest.of(0, 10);
//        Mockito.when(service.getAll(pageable)).thenReturn(Collections.singletonList(doctor));

//        List<Doctor> doctors = service.getAll();


//        Assertions.assertEquals(Collections.singletonList(doctor), doctors);
//        verifyNoMoreInteractions(repository);

    }

}