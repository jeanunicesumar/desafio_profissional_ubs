package com.saude.agenda.api.doctor;

import com.saude.agenda.api.doctor.dto.DoctorDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DoctorControllerTest {

    @InjectMocks
    private DoctorController doctorController;

    @Mock
    private DoctorService doctorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetById() {
        Long doctorId = 1L;
        DoctorDto doctorDto = new DoctorDto();

        when(doctorService.getById(doctorId)).thenReturn(doctorDto);

        ResponseEntity<DoctorDto> response = doctorController.getById(doctorId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(doctorDto, response.getBody());
    }

    @Test
    public void testFindAll() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<DoctorDto> doctorDtoPage = new PageImpl<>(Collections.emptyList());

        when(doctorService.getAll(pageable)).thenReturn(doctorDtoPage);

        ResponseEntity<Page<DoctorDto>> response = doctorController.findAll(pageable);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(doctorDtoPage, response.getBody());
    }

    @Test
    public void testSave() {
        DoctorDto doctorDto = new DoctorDto();

        doctorController.save(doctorDto);

        Mockito.verify(doctorService).register(doctorDto);
    }

    @Test
    public void testDeleteById() {
        Long doctorId = 1L;

        doctorController.deleteById(doctorId);

        Mockito.verify(doctorService).deleteById(doctorId);
    }
}
