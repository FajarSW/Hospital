package com.hmsapp.hospitalmanagement.doclogin.repository;

import com.hmsapp.hospitalmanagement.doclogin.enity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
