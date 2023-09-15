package com.saude.agenda.api.admin;

import com.saude.agenda.api.admin.dto.AdminDto;
import com.saude.agenda.api.doctor.Doctor;
import com.saude.agenda.api.doctor.DoctorRepository;
import com.saude.agenda.api.patient.Patient;
import com.saude.agenda.api.patient.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    @Autowired
    private AdminAdapter adapter;
    @Autowired
    private DoctorRepository doctorRepository; // Suponha que você tenha um repositório para Doctor
    @Autowired
    private PatientRepository patientRepository; // Suponha que você tenha um repositório para Patient



    public List<Admin> getAll(Pageable pageable) {
        return repository.findAll();
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
        Admin admin = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found"));
        return adapter.fromEntity(admin);
    }
    public void markDoctorAsDeleted(Long doctorId) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            doctor.setDeleted(false);
            doctorRepository.save(doctor);
        }
    }

    public void markPatientAsDeleted(Long patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setDeleted(false);
            patientRepository.save(patient);
        }
    }

    // update
}
