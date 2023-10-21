package com.saude.agenda.api.person;

import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.address.AddressAdapter;
import com.saude.agenda.api.person.dto.PersonDto;
import com.saude.agenda.api.ubs.UbsAdapter;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonAdapter implements Adapter<PersonDto, Person> {

    @Autowired
    private AddressAdapter addressAdapter;

    @Autowired
    private UbsAdapter ubsAdapter;

    @Override
    public PersonDto fromEntity(Person person) {
        return new PersonDto(person.getId(), person.getName(), person.getMotherName(), person.getFatherName(), person.getBirthDate(),
                person.getBirthCity(), person.getBirthUf(), person.getEmail(), person.getGender(), person.getDdd(), person.getPhone(),
                person.getCpf(), person.getPassword(), person.getActive(), addressAdapter.fromEntity(person.getAddress())
                , ubsAdapter.fromEntity(person.getUbs()));
    }

    @Override
    public Person fromDto(PersonDto personDto) {
        return new Person(personDto.getName(), personDto.getMotherName(), personDto.getFatherName(), personDto.getBirthDate(),
                personDto.getBirthCity(), personDto.getBirthUf(), personDto.getEmail(), personDto.getGender(), personDto.getDdd(), personDto.getPhone(),
                personDto.getCpf(), personDto.getPassword(), personDto.getActive(), addressAdapter.fromDto(personDto.getAddress())
                , ubsAdapter.fromDto(personDto.getUbs()));
    }

}
