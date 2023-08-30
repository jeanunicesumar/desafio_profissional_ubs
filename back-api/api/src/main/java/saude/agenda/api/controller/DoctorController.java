package saude.agenda.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import saude.agenda.api.doctor.*;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void setDoctor(@RequestBody @Valid DoctorRegister data){
        repository.save(new Doctor(data));
    }

    @GetMapping
    public Page<DoctorGet> getDoctorsRegister(@PageableDefault(size = 10, sort = {"fullName"}) Pageable pageable){
        return repository.findAllByActiveTrue(pageable).map(DoctorGet::new);
    }

    @PutMapping("/{id}")
    @Transactional
    public void updateDoctorRegister(@RequestBody @Valid DoctorUpdate data, @PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.updateDoctorRegister(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDoctorRegister(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.deleteDoctorRegister();

    }
}
