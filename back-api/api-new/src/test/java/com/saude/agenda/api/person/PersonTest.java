package com.saude.agenda.api.person;


import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.ubs.Ubs;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonTest {

    @Test
    public void testSetPerson(){
        Long id = 2L;
        String name = "Samuel Costa";
        String motherName = "Lucia Costa";
        String fatherName = "Lucas Costa";
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        String birthCity = "Maringa";
        String birthUf = "PR";
        String email = "samuel@gmail.com";
        Gender gender = Gender.MASCULINO;
        String ddd = "44";
        String phone = "99999-9999";
        String cpf = "06021665007";
        String password = "123456789";
        Boolean active = true;
        Address address = new Address("87050390", "Avenida Guedner", "Casa", "1025", "Zona 8", "Maringá", "PR");
        Ubs ubs = new Ubs(1L, "Jardim Aclimacao", address);
        Person person = new Person(name, motherName, fatherName, birthDate, birthCity, birthUf, email,gender, ddd, phone, cpf, password, active, address, ubs);

        assertNotNull(person);
        assertEquals(id, person.getId());
        assertEquals(name, person.getName());
        assertEquals(motherName, person.getMotherName());
        assertEquals(fatherName, person.getFatherName());
        assertEquals(birthDate, person.getBirthDate());
        assertEquals(birthCity, person.getBirthCity());
        assertEquals(birthUf, person.getBirthUf());
        assertEquals(email, person.getEmail());
        assertEquals(gender, person.getGender());
        assertEquals(ddd, person.getDdd());
        assertEquals(phone, person.getPhone());
        assertEquals(cpf, person.getCpf());
        assertEquals(password, person.getPassword());
        assertEquals(active, person.getActive());
    }
}

