package com.saude.agenda.api.admin;

import com.saude.agenda.api.admin.dto.AdminDto;
import com.saude.agenda.api.doctor.DoctorService;
import com.saude.agenda.api.patient.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;

    @Autowired
    private AdminAdapter adapter;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    public Page<AdminDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::getAdminDto);
    }

    private AdminDto getAdminDto(Admin admin) {
        return adapter.fromEntity(admin);
    }

    public AdminDto register(AdminDto data) {
        Admin admin = adapter.fromDto(data);
        repository.save(admin);
        return adapter.fromEntity(admin);
    }

    public AdminDto getById(Long id) {
        return adapter.fromEntity(findById(id));
    }

    public void markDoctorAsDeleted(Long doctorId) {
        doctorService.deleteById(doctorId);
    }

    public void markPatientAsDeleted(Long patientId) {
        patientService.deleteById(patientId);
    }

    private Admin findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));
    }

    // TODO: Fazer update
}
