package saude.agenda.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import saude.agenda.api.address.Address;
import saude.agenda.api.person.Gender;
import saude.agenda.api.person.Person;
import saude.agenda.api.person.PersonRegister;
import java.util.Date;


@Table(name = "doctors")
@Entity(name = "doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer susCode;

    private Person person;
}
