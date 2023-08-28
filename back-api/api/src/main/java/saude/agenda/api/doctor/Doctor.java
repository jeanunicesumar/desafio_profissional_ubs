package saude.agenda.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import saude.agenda.api.address.Address;
import saude.agenda.api.person.Gender;

import java.util.Date;
@Table(name = "doctors")
@Entity(name = "doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String motherName;
    private String fatherName;
    private Date birthDate;
    private String city;
    private String uf;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
    private String ddd;
    private String phone;
    private String cpf;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Embedded
    private Address address;
}
