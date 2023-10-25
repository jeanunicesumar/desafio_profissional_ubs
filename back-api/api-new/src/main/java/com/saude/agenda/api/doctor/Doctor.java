package com.saude.agenda.api.doctor;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.appointment.Appointment;
import com.saude.agenda.api.person.Gender;
import com.saude.agenda.api.person.Person;
import com.saude.agenda.api.specialty.Specialty;
import com.saude.agenda.api.ubs.Ubs;
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
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer crm;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "doctor_specialty",
            joinColumns = {@JoinColumn(name = "doctor_id")},
            inverseJoinColumns = {@JoinColumn(name = "specialty_id")}
    )
    private List<Specialty> specialties;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private List<Appointment> appointments;

    public Doctor(Integer crm) {
        this.crm = crm;
    }

}
