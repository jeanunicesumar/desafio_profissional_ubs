package com.saude.agenda.api.doctor;


import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.address.AddressAdapter;
import com.saude.agenda.api.doctor.dto.DoctorDto;
import com.saude.agenda.api.ubs.UbsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorAdapter implements Adapter<DoctorDto, Doctor> {

    @Autowired
    private AddressAdapter addressAdapter;

    @Autowired
    private UbsAdapter ubsAdapter;

    @Override
    public DoctorDto fromEntity(Doctor doctor) {
        return new DoctorDto(doctor.getCrm(), doctor.getId(), doctor.getName(), doctor.getMotherName(), doctor.getFatherName(),
                doctor.getBirthDate(), doctor.getBirthCity(), doctor.getBirthUf(), doctor.getEmail(), doctor.getGender(),
                doctor.getDdd(), doctor.getPhone(), doctor.getCpf(), doctor.getPassword(), doctor.getActive(), addressAdapter.fromEntity(doctor.getAddress()),
                ubsAdapter.fromEntity(doctor.getUbs()));
    }

    @Override
    public Doctor fromDto(DoctorDto doctorDto) {
        return new Doctor(doctorDto.getCrm(),
                doctorDto.getName(), doctorDto.getMotherName(), doctorDto.getFatherName(),
                doctorDto.getBirthDate(), doctorDto.getBirthCity(), doctorDto.getBirthUf(), doctorDto.getEmail(), doctorDto.getGender(),
                doctorDto.getDdd(), doctorDto.getPhone(), doctorDto.getCpf(), doctorDto.getPassword(), doctorDto.getActive(),
                addressAdapter.fromDto(doctorDto.getAddress()), ubsAdapter.fromDto(doctorDto.getUbs()));
    }
}
