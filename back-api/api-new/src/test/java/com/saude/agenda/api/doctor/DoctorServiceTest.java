package com.saude.agenda.api.doctor;

import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.doctor.dto.DoctorDto;
import com.saude.agenda.api.person.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {

    @InjectMocks
    DoctorService service;

    @Mock
    DoctorRepository repository;

    @Mock
    DoctorAdapter adapter;

    private Doctor doctor;
    private Address address;

    @BeforeEach
    public void setUp() {
        address = new Address("87230-230", "Rua Tal", "Complemento", "123A", "Bairro tal", "Maringá", "PR");
        doctor = new Doctor(1231231, "carlos", "maria", "joao",
                LocalDate.of(2020, 1, 8),
                "Maringá", "PR", "teste@gmail.com",
                Gender.MASCULINO, "44", "99999-9999", "123.456.789-10", "1234", true, address);
    }

    @Test
    void should_return_list_doctorDto_when_catch_service_get_all() {
        DoctorDto doctorDto = adapter.fromEntity(doctor);
        when(service.getAll()).thenReturn(Collections.singletonList(doctorDto));

        List<DoctorDto> doctors = service.getAll();

        assertEquals(Collections.singletonList(doctorDto), doctors);
        verifyNoMoreInteractions(repository);

    }

    @Test
    void should_return_ok_when_register_one_doctor() {
        DoctorDto doctorDtoExpected = adapter.fromEntity(doctor);
        when(service.register(doctorDtoExpected)).thenReturn(doctorDtoExpected);

        DoctorDto doctorDto = service.register(doctorDtoExpected);

        assertEquals(doctorDto, doctorDtoExpected);
    }

}