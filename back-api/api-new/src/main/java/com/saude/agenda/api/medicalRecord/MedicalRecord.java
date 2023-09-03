package com.saude.agenda.api.medicalRecord;

import com.saude.agenda.api.address.Address;
import com.saude.agenda.api.person.Gender;
import com.saude.agenda.api.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "medicalRecord")
@NoArgsConstructor
@Getter
@Setter
public class MedicalRecord {

    @Column(nullable = false)
    private Long id;
    private String description;
    private Date medicalRecordDate;

    public MedicalRecord (
            Long id,
            String description,
            Date medicalRecordDate
                  ) {
        this.id = id;
        this.description = description;
        this.medicalRecordDate = medicalRecordDate;
    }
}
