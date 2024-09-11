package com.hmsapp.hospitalmanagement.controller;

import com.hmsapp.hospitalmanagement.entity.Patient;
import com.hmsapp.hospitalmanagement.entity.Appointmen;
import com.hmsapp.hospitalmanagement.service.PatientService;
import com.hmsapp.hospitalmanagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @Autowired
    public AdminController(PatientService patientService, AppointmentService appointmentService) {
        this.patientService = patientService;
        this.appointmentService = appointmentService;
    }

    // Patient Endpoints
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable long id) throws AttributeNotFoundException {
        Patient patient = patientService.getPatientById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found by id " + id));
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException {
        patientService.deletePatient(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // Appointment Endpoints
    @GetMapping("/appointments")
    public List<Appointmen> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<Appointmen> getAppointmentById(@PathVariable long id) throws AttributeNotFoundException {
        Appointmen appointment = appointmentService.getAppointmentById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Appointment not found by id " + id));
        return ResponseEntity.ok(appointment);
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable long id) throws AttributeNotFoundException {
        appointmentService.deleteAppointment(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
