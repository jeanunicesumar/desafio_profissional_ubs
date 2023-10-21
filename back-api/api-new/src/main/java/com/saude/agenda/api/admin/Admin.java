package com.saude.agenda.api.admin;

import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.person.Gender;
import com.saude.agenda.api.person.Person;
import com.saude.agenda.api.ubs.Ubs;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@DiscriminatorValue("admin")
@Entity
@Table(name = "admin")
@NoArgsConstructor
@Getter
@Setter
public class Admin extends Person {
    public Admin(String name, String motherName,
                 String fatherName, LocalDate birthDate, String birthCity,
                 String birthUf, String email, Gender gender,
                 String ddd, String phone, String cpf, String password,
                 Boolean active, Address address, Ubs ubs) {
        super(name, motherName, fatherName, birthDate, birthCity, birthUf, email, gender, ddd, phone, cpf, password, active, address, ubs);
    }
}
