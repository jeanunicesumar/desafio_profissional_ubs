package com.saude.agenda.api.doctor;


import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.doctor.dto.DoctorDto;

public class DoctorAdapter implements Adapter<DoctorDto, Doctor> {
    @Override
    public DoctorDto fromEntity(Doctor doctor) {
        return new DoctorDto(doctor.getCrm(), doctor.getId(), doctor.getName(), doctor.getMotherName(), doctor.getFatherName(),
                doctor.getBirthDate(), doctor.getBirthCity(), doctor.getBirthUf(), doctor.getEmail(), doctor.getGender(),
                doctor.getDdd(), doctor.getPhone(), doctor.getCpf(), doctor.getActive(), doctor.getAddress()
                );
    }

    @Override
    public Doctor fromDto(DoctorDto doctorDto) {
        return new Doctor(doctorDto.getCrm(), doctorDto.getId(), doctorDto.getName(), doctorDto.getMotherName(), doctorDto.getFatherName(),
                doctorDto.getBirthDate(), doctorDto.getBirthCity(), doctorDto.getBirthUf(), doctorDto.getEmail(), doctorDto.getGender(),
                doctorDto.getDdd(), doctorDto.getPhone(), doctorDto.getCpf(), doctorDto.getActive(), doctorDto.getAddress());
    }
}
