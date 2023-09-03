package com.saude.agenda.api.doctor;

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
@Table(name = "doctor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor extends Person {

    @Column(nullable = false)
    private Integer crm;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private List<Appointment> appointments;

    public Doctor(Integer crm, String name, String motherName, String fatherName, LocalDate birthDate, String birthCity, String birthUf, String email, Gender gender, String ddd, String phone, String cpf, Boolean active, Address address) {
        super(name, motherName, fatherName, birthDate, birthCity, birthUf, email, gender, ddd, phone, cpf, active, address);
        this.crm = crm;
    }

}
