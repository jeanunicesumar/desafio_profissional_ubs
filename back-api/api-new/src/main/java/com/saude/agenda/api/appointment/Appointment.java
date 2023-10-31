package com.saude.agenda.api.appointment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saude.agenda.api.doctor.Doctor;
import com.saude.agenda.api.medicalRecord.MedicalRecord;
import com.saude.agenda.api.patient.Patient;
import com.saude.agenda.api.person.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

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
    private LocalDate date;

    private StatusAppointment status;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_record_id", referencedColumnName = "id")
    private MedicalRecord medicalRecord;

    public Appointment(Timestamp startTime, Timestamp endTime, LocalDate date, Patient patient, Doctor doctor, MedicalRecord medicalRecord, StatusAppointment status) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.status = StatusAppointment.WAITING_CONFIRMATION;
        this.patient = patient;
        this.doctor = doctor;
        this.medicalRecord = medicalRecord;
        this.status = status;

    }
}
