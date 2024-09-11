package com.hmsapp.hospitalmanagement.doclogin.repository;

import com.hmsapp.hospitalmanagement.doclogin.enity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
