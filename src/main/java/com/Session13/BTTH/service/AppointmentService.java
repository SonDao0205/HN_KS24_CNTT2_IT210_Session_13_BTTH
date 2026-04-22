package com.Session13.BTTH.service;

import com.Session13.BTTH.model.Appointment;
import com.Session13.BTTH.repository.AppointmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AppointmentService {
    @Autowired
    private AppointmentRepository repository;

    public List<Appointment> getWaitingList() { return repository.findWaitingList(); }

    public void addAppointment(Appointment a) { repository.save(a); }

    public void callPatient(Long id) {
        Appointment a = repository.findById(id);
        if (a != null) {
            a.setStatus(1);
            repository.save(a);
        }
    }
}
