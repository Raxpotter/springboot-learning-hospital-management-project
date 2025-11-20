package com.RaxPotter.hospitalManagementSystem;

import com.RaxPotter.hospitalManagementSystem.dto.AppointmentDTO;
import com.RaxPotter.hospitalManagementSystem.entity.Appointment;
import com.RaxPotter.hospitalManagementSystem.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTests {

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void createAppointment() {
        Appointment appointment = Appointment.builder()
                .reason("Tuberclosis")
                .appointmentTime(LocalDateTime.of(2025,11,25,12,30))
                .build();

        AppointmentDTO newAppointment = appointmentService.createNewAppointment(appointment, 1L, 3L);

        System.out.println("Appointment booked: "+ newAppointment);

        AppointmentDTO updatedAppointment = appointmentService.reassignAppointmentToAnotherDoctor(newAppointment.getId(), 2L);

        System.out.println("Appointment Updated: "+ updatedAppointment);
    }
}

