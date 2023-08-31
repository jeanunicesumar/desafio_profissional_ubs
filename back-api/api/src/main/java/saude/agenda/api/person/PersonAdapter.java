package saude.agenda.api.person;

import saude.agenda.api.adapter.Adapter;
import saude.agenda.api.person.dto.PersonDto;

public class PersonAdapter implements Adapter<PersonDto, Person> {
    @Override
    public PersonDto fromEntity(Person person) {
        return new PersonDto(person.getId(), person.getName(), person.getMotherName(),
                person.getFatherName(), person.getBirthDate(), person.getEmail(), person.getGender(),
                person.getDdd(), person.getPhone(), person.getCpf());
    }

    @Override
    public Person fromDto(PersonDto personDto) {
        return new Person(personDto.getId(), personDto.getName(), personDto.getMotherName(), personDto.getFatherName(),
                personDto.getBirthDate(), personDto.getEmail(), personDto.getGender(), personDto.getDdd(), personDto.getPhone(),
                personDto.getCpf());
    }
}
