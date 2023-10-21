package com.saude.agenda.api.doctor;


import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.address.AddressAdapter;
import com.saude.agenda.api.doctor.dto.DoctorDto;
import com.saude.agenda.api.person.PersonAdapter;
import com.saude.agenda.api.ubs.UbsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorAdapter implements Adapter<DoctorDto, Doctor> {

    @Autowired
    private AddressAdapter addressAdapter;

    @Autowired
    private UbsAdapter ubsAdapter;

    @Autowired
    private PersonAdapter personAdapter;

    @Override
    public DoctorDto fromEntity(Doctor doctor) {
        return new DoctorDto(doctor.getId(), doctor.getCrm(), personAdapter.fromEntity(doctor.getPerson()));
    }

    @Override
    public Doctor fromDto(DoctorDto doctorDto) {
        return new Doctor(doctorDto.getCrm());
    }
}
