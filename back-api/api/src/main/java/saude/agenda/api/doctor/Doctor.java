package saude.agenda.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import saude.agenda.api.address.Address;
import saude.agenda.api.person.Gender;
import saude.agenda.api.person.PersonRegister;
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
    private String cityBirth;
    private String ufBirth;

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

    private Boolean active;

    public Doctor(PersonRegister person, DoctorRegister doctor) {
        this.active = true;
        this.fullName = person.fullName();
        this.motherName = person.motherName();
        this.fatherName = person.fatherName();
        this.birthDate = person.birthDate();
        this.cityBirth = person.birthCity();
        this.ufBirth = person.birthUf();
        this.gender = person.gender();
        this.ddd = person.ddd();
        this.phone = person.phone();
        this.cpf = person.cpf();
        this.crm = doctor.crm();
        this.specialty = doctor.specialty();
        this.address = new Address(person.address());

    }

    public void updateDoctorRegister(DoctorUpdate data) {
        if(data.phone() != null) {
            this.phone = data.phone();
        }
        if(data.address() != null){
            this.address.updateAddress(data.address());
        }
    }

    public void deleteDoctorRegister() {
        this.active = false;
    }
}
