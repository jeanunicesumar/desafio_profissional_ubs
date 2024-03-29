package com.saude.agenda.api.person;

import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.appointment.Appointment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String motherName;

    private String fatherName;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String birthCity;

    @Column(nullable = false)
    private String birthUf;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private String ddd;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean active;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Person(String name, String motherName, String fatherName, LocalDate birthDate, String birthCity, String birthUf, String email, Gender gender, String ddd, String phone, String cpf, String password, Boolean active, Address address) {
        this.name = name;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.birthDate = birthDate;
        this.birthCity = birthCity;
        this.birthUf = birthUf;
        this.email = email;
        this.gender = gender;
        this.ddd = ddd;
        this.phone = phone;
        this.cpf = cpf;
        this.password = password;
        this.active = active;
        this.address = address;
    }
}
