package saude.agenda.api.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import saude.agenda.api.doctor.dto.DoctorDto;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private DoctorAdapter adapter;

    public List<DoctorDto> getAll() {
        return null;
//        return repository.findAllByActiveTrue(pageable).map(doctor -> adapter.fromEntity(doctor));
    }


}
