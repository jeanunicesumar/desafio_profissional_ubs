package saude.agenda.api.doctor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import saude.agenda.api.person.Gender;
import saude.agenda.api.person.Person;

import java.util.Date;


@Table(name = "doctors")
@Entity(name = "doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Person {

    @Column(nullable = false)
    private Integer susCode;

    private Long active;

    public Doctor(Integer susCode, Long id, String name, String motherName, String fatherName, Date birthDate,
                  String email, Gender gender, String ddd, String phone, String cpf) {

        super(id, name, motherName, fatherName, birthDate, email, gender, ddd, phone, cpf);
        this.susCode = susCode;
    }
}
