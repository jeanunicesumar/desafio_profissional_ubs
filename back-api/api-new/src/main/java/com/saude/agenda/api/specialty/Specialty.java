package com.saude.agenda.api.specialty;

import com.saude.agenda.api.doctorSpecialty.DoctorSpecialty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "specialty")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "specialty")
    List<DoctorSpecialty> doctorSpecialties;

}
