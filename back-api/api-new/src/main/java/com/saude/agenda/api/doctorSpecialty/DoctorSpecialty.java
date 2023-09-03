package com.saude.agenda.api.doctorSpecialty;

import com.saude.agenda.api.doctor.Doctor;
import com.saude.agenda.api.specialty.Specialty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor_specialty")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorSpecialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

}
