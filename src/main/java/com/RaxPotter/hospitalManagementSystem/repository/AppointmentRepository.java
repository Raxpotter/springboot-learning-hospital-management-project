package com.RaxPotter.hospitalManagementSystem.repository;

import com.RaxPotter.hospitalManagementSystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
