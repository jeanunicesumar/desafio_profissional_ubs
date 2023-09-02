package com.saude.agenda.api.doctor;

import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.person.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    private Doctor doctor;
    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address(1L, "87230-230", "Rua Tal", "Complemento", "123A", "Bairro tal", "Maringá", "PR");
        doctor = new Doctor(123L, 1L, "carlos", "maria", "joao", new Date(2010, 11, 23), "Maringá", "PR", "teste@gmail.com",
                Gender.MASCULINO, "44", "99999-9999", "123.456.789-10", true, address);
    }

    @Test
    public void should_return_status_ok_when_get_all_doctor() {
        Pageable pageable = PageRequest.of(0, 10);
//        Mockito.when(service.getAll(pageable)).thenReturn(Collections.singletonList(doctor));

        List<Doctor> doctors = service.getAll(pageable);


        Assertions.assertEquals(Collections.singletonList(doctor), doctors);
        verifyNoMoreInteractions(repository);

    }

}