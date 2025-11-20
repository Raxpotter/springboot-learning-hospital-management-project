package com.RaxPotter.hospitalManagementSystem.repository;

import com.RaxPotter.hospitalManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByName(String name);
    Optional<Patient> findByEmail(String name);
    Optional<Patient> findByNameAndEmail(String name, String email);

}
