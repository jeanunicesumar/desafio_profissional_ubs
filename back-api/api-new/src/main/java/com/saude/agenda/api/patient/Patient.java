package com.saude.agenda.api.patient;

import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.appointment.Appointment;
import com.saude.agenda.api.person.Gender;
import com.saude.agenda.api.person.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient extends Person {

    @Column(nullable = false)
    private Integer susCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Appointment> appointments;

    public Patient(Integer susCode,
                   String name,
                   String motherName,
                   String fatherName,
                   LocalDate birthDate,
                   String birthCity,
                   String birthUf,
                   String email,
                   Gender gender,
                   String ddd,
                   String phone,
                   String cpf,
                   String password,
                   Boolean active,
                   Address address) {
        super(name, motherName, fatherName, birthDate, birthCity, birthUf, email, gender, ddd, phone, cpf, password, active, address);
        this.susCode = susCode;
    }
}
