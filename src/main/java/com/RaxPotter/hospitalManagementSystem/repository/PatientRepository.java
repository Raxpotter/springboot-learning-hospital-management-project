package com.RaxPotter.hospitalManagementSystem.repository;

import com.RaxPotter.hospitalManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
