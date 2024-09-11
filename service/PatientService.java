package com.hmsapp.hospitalmanagement.service;

import com.hmsapp.hospitalmanagement.entity.Patient;
import com.hmsapp.hospitalmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.AttributeNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(long id) {
        return patientRepository.findById(id);
    }

    public void deletePatient(long id) throws AttributeNotFoundException {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found with id " + id));
        patientRepository.delete(patient);
    }

}
