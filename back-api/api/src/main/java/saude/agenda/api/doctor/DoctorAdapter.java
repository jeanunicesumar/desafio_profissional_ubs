package saude.agenda.api.doctor;

import saude.agenda.api.adapter.Adapter;
import saude.agenda.api.doctor.dto.DoctorDto;
import saude.agenda.api.person.Person;
import saude.agenda.api.person.dto.PersonDto;

import javax.print.Doc;

public class DoctorAdapter implements Adapter<DoctorDto, Doctor> {
    @Override
    public DoctorDto fromEntity(Doctor doctor) {
        Person person = doctor.getPerson();
        return new DoctorDto(doctor.getId(), doctor.getSusCode(),
                new PersonDto(person.getId(), person.getName(), person.getMotherName(), person.getFatherName(),
                        person.getBirthDate(), person.getEmail(), person.getGender(), person.getDdd(), person.getPhone(),
                        person.getCpf()));
    }

    @Override
    public Doctor fromDto(DoctorDto doctorDto) {
        PersonDto person = doctorDto.getPersonDto();
        return new Doctor(doctorDto.getId(), doctorDto.getSusCode(), new Person(person.getId(), person.getName(), person.getMotherName(),
                person.getFatherName(), person.getBirthDate(), person.getEmail(), person.getGender(), person.getDdd(),
                person.getPhone(), person.getCpf()));
    }
}
