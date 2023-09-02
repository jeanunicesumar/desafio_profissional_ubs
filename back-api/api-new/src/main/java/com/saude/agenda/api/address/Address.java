package com.saude.agenda.api.address;

import com.saude.agenda.api.person.Person;
import com.saude.agenda.api.ubs.Ubs;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@AllArgsConstructor
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "address")
    private Person person;

    @OneToOne(mappedBy = "address")
    private Ubs ubs;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String streetAddress;

    private String streetAddressII;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String uf;

    public Address(Long id, String zipCode, String streetAddress, String streetAddressII,
                   String number, String district, String city, String uf) {
        this.id = id;
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
        this.streetAddressII = streetAddressII;
        this.number = number;
        this.district = district;
        this.city = city;
        this.uf = uf;
    }
}
