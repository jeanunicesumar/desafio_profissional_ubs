package com.saude.agenda.api.appointment;

import com.saude.agenda.api.adapter.Adapter;
import com.saude.agenda.api.appointment.dto.AppointmentDto;
import com.saude.agenda.api.doctor.Doctor;
import com.saude.agenda.api.doctor.DoctorAdapter;
import com.saude.agenda.api.medicalRecord.MedicalRecord;
import com.saude.agenda.api.medicalRecord.MedicalRecordAdapter;
import com.saude.agenda.api.patient.PatientAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentAdapter implements Adapter<AppointmentDto, Appointment> {

    @Autowired
    private PatientAdapter patientAdapter;

    @Autowired
    private DoctorAdapter doctorAdapter;

    @Autowired
    private MedicalRecordAdapter medicalRecordAdapter;

    @Override
    public AppointmentDto fromEntity(Appointment appointment) {
        return new AppointmentDto(appointment.getId(), appointment.getStartTime(), appointment.getEndTime(), appointment.getDate(),
                patientAdapter.fromEntity(appointment.getPatient()), doctorAdapter.fromEntity(appointment.getDoctor()),
                medicalRecordAdapter.fromEntity(appointment.getMedicalRecord()), appointment.getStatus());
    }

    @Override
    public Appointment fromDto(AppointmentDto appointmentDto) {
        return new Appointment(appointmentDto.getStartTime(), appointmentDto.getEndTime(),
                appointmentDto.getDate(), patientAdapter.fromDto(appointmentDto.getPatient()),
                doctorAdapter.fromDto(appointmentDto.getDoctor()),
                medicalRecordAdapter.fromDto(appointmentDto.getMedicalRecord()), appointmentDto.getStatusAppointment());
    }
}
