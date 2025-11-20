package com.RaxPotter.hospitalManagementSystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {

    private Long id;
    private String reason;
    private LocalDateTime appointmentTime;
    private DoctorDTO doctor;
}
