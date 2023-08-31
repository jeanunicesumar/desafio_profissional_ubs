package saude.agenda.api.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import saude.agenda.api.doctor.dto.DoctorDto;
import saude.agenda.api.person.Gender;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private DoctorAdapter adapter;

    public List<DoctorDto> getAll() {
        Doctor doctor = new Doctor(23712831,1L, "Cassia", "Marcia", "Carlos", new Date(1999, 11, 23),
                "cassia@gmail.com", Gender.FEMININO, "44", "99999-9999", "321321312"
        );
        return Collections.singletonList(adapter.fromEntity(doctor));
//        return repository.findAllByActiveTrue(pageable).map(doctor -> adapter.fromEntity(doctor));
    }


}
