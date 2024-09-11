package com.hmsapp.hospitalmanagement.service;

import com.hmsapp.hospitalmanagement.entity.Appointmen;
import com.hmsapp.hospitalmanagement.repository.repAppointmen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final repAppointmen appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(repAppointmen appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointmen> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Optional<Appointmen> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public Appointmen saveAppointment(Appointmen appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
