package com.hmsapp.hospitalmanagement.controller;

import com.hmsapp.hospitalmanagement.entity.Appointmen;
import com.hmsapp.hospitalmanagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointments")
public class contrAppointmen {

    private final AppointmentService appointmentService;

    @Autowired
    public contrAppointmen(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointmen> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointmen> getAppointmentById(@PathVariable Long id) throws AttributeNotFoundException {
        Optional<Appointmen> appointment = appointmentService.getAppointmentById(id);
        return appointment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Appointmen createAppointment(@RequestBody Appointmen appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) throws AttributeNotFoundException {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
