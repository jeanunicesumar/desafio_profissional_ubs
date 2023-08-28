package saude.agenda.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saude.agenda.api.doctor.DoctorRegister;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @PostMapping
    public void registerDoctor(@RequestBody DoctorRegister data){
        System.out.println(data);
    }
}
