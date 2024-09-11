package com.hmsapp.hospitalmanagement.repository;

import com.hmsapp.hospitalmanagement.entity.Appointmen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repAppointmen extends JpaRepository<Appointmen, Long> {
    // Tambahkan metode khusus jika diperlukan
}
