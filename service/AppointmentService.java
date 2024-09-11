package com.hmsapp.hospitalmanagement.service;

import com.hmsapp.hospitalmanagement.entity.Appointmen;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<Appointmen> getAllAppointments();
    Optional<Appointmen> getAppointmentById(Long id);
    Appointmen saveAppointment(Appointmen appointment);
    void deleteAppointment(Long id);
}
