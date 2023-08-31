package saude.agenda.api.person;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private Date birthDate;

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

}
