package com.saude.agenda.api.admin;

import com.saude.agenda.api.admin.dto.AdminDto;
import com.saude.agenda.api.doctor.DoctorService;
import com.saude.agenda.api.patient.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AdminServiceTest {

    @Mock
    private AdminRepository repository;

    @Mock
    private AdminAdapter adapter;

    @Mock
    private DoctorService doctorService;

    @Mock
    private PatientService patientService;

    @InjectMocks
    private AdminService adminService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister() {
        AdminDto adminDto = new AdminDto();
        Admin admin = new Admin();
        when(adapter.fromDto(adminDto)).thenReturn(admin);
        when(repository.save(admin)).thenReturn(admin);
        when(adapter.fromEntity(admin)).thenReturn(adminDto);

        AdminDto result = adminService.register(adminDto);

        assertNotNull(result);
        verify(repository).save(admin);
    }

    @Test
    public void testGetById() {
        Admin admin = new Admin();
        admin.setId(1L);
        AdminDto adminDto = new AdminDto();
        adminDto.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(admin));
        when(adapter.fromEntity(admin)).thenReturn(adminDto);

        AdminDto result = adminService.getById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testExists() {
        when(repository.existsByPersonId(1L)).thenReturn(true);

        boolean result = adminService.exists(1L);

        assertTrue(result);
    }

    @Test
    public void testMarkDoctorAsDeleted() {
        adminService.markDoctorAsDeleted(1L);

        verify(doctorService).deleteById(1L);
    }

    @Test
    public void testMarkPatientAsDeleted() {
        adminService.markPatientAsDeleted(1L);

        verify(patientService).deleteById(1L);
    }

    @Test
    public void testUpdateById() {
        Admin existingAdmin = new Admin();
        existingAdmin.setId(1L);
        Admin updatedAdmin = new Admin();
        updatedAdmin.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(existingAdmin));
        when(repository.save(updatedAdmin)).thenReturn(updatedAdmin);

        Admin result = adminService.updateById(1L, updatedAdmin);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }
}

