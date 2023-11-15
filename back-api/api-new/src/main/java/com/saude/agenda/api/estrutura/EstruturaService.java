package com.saude.agenda.api.estrutura;

import com.saude.agenda.api.appointment.Appointment;
import com.saude.agenda.api.appointment.AppointmentAdapter;
import com.saude.agenda.api.appointment.AppointmentRepository;
import com.saude.agenda.api.appointment.dto.AppointmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstruturaService {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private AppointmentAdapter adapter;

    public List<AppointmentDto> getAppointment() {

        List<Appointment> appointments = repository.findAll();
        List<Appointment> collect = appointments.stream()
                .sorted(Comparator.comparing(Appointment::getDate))
                .toList();

        repository.deleteAll();
        repository.saveAll(collect);

        return repository.findAll()
                .stream()
                .map(t -> adapter.fromEntity(t))
                .collect(Collectors.toList());

    }

}
