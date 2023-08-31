package saude.agenda.api.doctor;

import saude.agenda.api.adapter.Adapter;
import saude.agenda.api.doctor.dto.DoctorDto;

public class DoctorAdapter implements Adapter<DoctorDto, Doctor> {

    @Override
    public DoctorDto fromEntity(Doctor doctor) {
        return new DoctorDto(doctor.getSusCode(), doctor.getId(), doctor.getName(), doctor.getMotherName(), doctor.getFatherName(),
                doctor.getBirthDate(), doctor.getEmail(), doctor.getGender(), doctor.getDdd(), doctor.getPhone(),
                doctor.getCpf());
    }

    @Override
    public Doctor fromDto(DoctorDto doctorDto) {
        return new Doctor(doctorDto.getSusCode(), doctorDto.getId(), doctorDto.getName(), doctorDto.getMotherName(),
                doctorDto.getFatherName(), doctorDto.getBirthDate(), doctorDto.getEmail(), doctorDto.getGender(), doctorDto.getDdd(),
                doctorDto.getPhone(), doctorDto.getCpf());
    }

}
