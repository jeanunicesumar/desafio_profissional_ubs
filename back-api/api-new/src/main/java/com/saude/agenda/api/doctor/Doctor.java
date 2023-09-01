package com.saude.agenda.api.doctor;

import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.person.Gender;
import com.saude.agenda.api.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "doctor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor extends Person {

    @Column(nullable = false)
    private Long crm;

    public Doctor(Long crm,
                  Long id,
                  String name,
                  String motherName, String fatherName, Date birthDate, String birthCity,
                  String birthUf, String email, Gender gender, String ddd, String phone, String cpf, Long active,
                  Address address) {
        super(id, name, motherName, fatherName, birthDate, birthCity, birthUf, email, gender, ddd, phone, cpf, active, address);
        this.crm = crm;
    }
}
