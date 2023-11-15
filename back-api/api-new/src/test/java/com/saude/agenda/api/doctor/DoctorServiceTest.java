package com.saude.agenda.api.doctor;

import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.doctor.dto.DoctorDto;
import com.saude.agenda.api.helper.HashPassword;
import com.saude.agenda.api.person.Gender;
import com.saude.agenda.api.person.Person;
import com.saude.agenda.api.person.dto.PersonDto;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.StringUtil;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class DoctorServiceTest {

    @InjectMocks
    private DoctorService doctorService;

    @Mock
    private DoctorRepository doctorRepository;

    @Mock
    private DoctorAdapter adapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        Pageable pageable = Pageable.unpaged();
        Page<Doctor> doctorPage = new PageImpl<>(Collections.emptyList());
        when(doctorRepository.findAll(pageable)).thenReturn(doctorPage);

        doctorService.getAll(pageable);

        verify(doctorRepository, times(1)).findAll(pageable);
    }

    @Test
    public void testRegister() {
        DoctorDto doctorDto = new DoctorDto();
        Doctor doctor = new Doctor();

        doctorDto.setPerson(new PersonDto());
        doctorDto.getPerson().setPassword("teste");

        when(adapter.fromDto(doctorDto)).thenReturn(doctor);
        when(doctorRepository.save(doctor)).thenReturn(doctor);
        doctorService.register(doctorDto);

        verify(adapter, times(1)).fromDto(doctorDto);
        verify(doctorRepository, times(1)).save(doctor);
    }

    @Test
    public void testGetById() {
        Long id = 1L;
        Doctor doctor = new Doctor();
        DoctorDto doctorDto = new DoctorDto();

        when(doctorRepository.findById(id)).thenReturn(java.util.Optional.of(doctor));
        when(adapter.fromEntity(doctor)).thenReturn(doctorDto);

        DoctorDto result = doctorService.getById(id);

        assertNotNull(result);
        verify(doctorRepository, times(1)).findById(id);
        verify(adapter, times(1)).fromEntity(doctor);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;
        Doctor doctor = new Doctor();

        doctor.setPerson(new Person());

        when(doctorRepository.findById(id)).thenReturn(java.util.Optional.of(doctor));
        when(adapter.fromEntity(doctor)).thenReturn(new DoctorDto());

        doctorService.deleteById(id);

        verify(doctorRepository, times(1)).findById(id);
        verify(doctorRepository, times(1)).save(doctor);
        assertFalse(doctor.getPerson().getActive());
    }

}