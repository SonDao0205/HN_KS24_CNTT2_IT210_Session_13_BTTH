package com.Session13.BTTH.repository;

import com.Session13.BTTH.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentRepository {
    @Autowired
    private org.hibernate.SessionFactory sessionFactory;

    public List<Appointment> findWaitingList() {
        String hql = "FROM Appointment a WHERE a.status = 0 ORDER BY a.appointmentTime ASC";
        return sessionFactory.getCurrentSession().createQuery(hql, Appointment.class).list();
    }

    public void save(Appointment appointment) {
        sessionFactory.getCurrentSession().merge(appointment);
    }

    public Appointment findById(Long id) {
        return sessionFactory.getCurrentSession().find(Appointment.class, id);
    }
}
