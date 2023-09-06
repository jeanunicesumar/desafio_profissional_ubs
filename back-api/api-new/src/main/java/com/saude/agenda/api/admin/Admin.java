package com.saude.agenda.api.admin;

import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.person.Gender;
import com.saude.agenda.api.person.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "admin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Admin extends Person {
    public Admin(Long id, String name, String motherName,
                 String fatherName, LocalDate birthDate, String birthCity,
                 String birthUf, String email, Gender gender,
                 String ddd, String phone, String cpf,
                 Boolean active, Address address) {
        super(id, name, motherName, fatherName, birthDate, birthCity, birthUf, email, gender, ddd, phone, cpf, active, address);
    }
}