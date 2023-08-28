package saude.agenda.api.patient;

import saude.agenda.api.address.AddressRecord;
import saude.agenda.api.person.Gender;

import java.util.Date;

public record PatientRegister(String fullName,
                              String motherName,
                              String fatherName,
                              Date birthDate,
                              String city,
                              String uf,
                              Gender gender,
                              String ddd,
                              String phone,
                              String cpf,
                              String susNumber,
                              AddressRecord addressRecord) {
}
