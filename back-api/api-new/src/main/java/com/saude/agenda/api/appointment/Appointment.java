package com.saude.agenda.api.appointment;

import com.saude.agenda.api.doctor.Doctor;
import com.saude.agenda.api.medicalRecord.MedicalRecord;
import com.saude.agenda.api.person.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "appointment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Timestamp startTime;

    @Column(nullable = false)
    private Timestamp endTime;

    @Column(nullable = false)
    private Date date;

    private StatusAppointment status;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_record_id", referencedColumnName = "id")
    private MedicalRecord medicalRecord;

    public Appointment(Timestamp startTime, Timestamp endTime, Date date, Person person, Doctor doctor, MedicalRecord medicalRecord) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.status = StatusAppointment.WAITING_CONFIRMATION;
        this.person = person;
        this.doctor = doctor;
        this.medicalRecord = medicalRecord;
    }
}
