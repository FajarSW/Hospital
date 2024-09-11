package com.hmsapp.hospitalmanagement.repository;

import com.hmsapp.hospitalmanagement.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByUsername(String username);
}
