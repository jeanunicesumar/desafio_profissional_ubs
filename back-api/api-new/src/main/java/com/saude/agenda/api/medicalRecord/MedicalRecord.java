package com.saude.agenda.api.medicalRecord;

import com.saude.agenda.api.appointment.Appointment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "medicalRecord")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Date date;

    @OneToOne(mappedBy = "medicalRecord")
    private Appointment appointment;

    public MedicalRecord(Long id, Date date, String description) {
        this.id = id;
        this.date = date;
        this.description = description;
    }
}
