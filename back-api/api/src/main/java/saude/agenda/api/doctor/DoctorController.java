package saude.agenda.api.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saude.agenda.api.doctor.dto.DoctorDto;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

//    @PostMapping
//    @Transactional
//    public void setDoctor(@RequestBody @Valid DoctorRegister data){
////        repository.save(new Doctor(data));
//    }

    @GetMapping
    public List<DoctorDto> getDoctorsRegister(@PageableDefault(size = 10, sort = {"fullName"}) Pageable pageable){
//        return repository.findAllByActiveTrue(pageable).map(DoctorGet::new);
        return service.getAll();
    }

//    @PutMapping("/{id}")
//    @Transactional
//    public void updateDoctorRegister(@RequestBody @Valid DoctorUpdate data, @PathVariable Long id){
////        var doctor = repository.getReferenceById(id);
////        doctor.updateDoctorRegister(data);
//    }
//
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void deleteDoctorRegister(@PathVariable Long id){
////        var doctor = repository.getReferenceById(id);
////        doctor.deleteDoctorRegister();
//
//    }
}
