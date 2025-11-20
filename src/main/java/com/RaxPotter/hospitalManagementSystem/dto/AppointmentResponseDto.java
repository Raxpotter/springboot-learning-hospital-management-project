package com.RaxPotter.hospitalManagementSystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponseDto {
    private Long id;
    private String reason;
    private LocalDateTime appointmentTime;
    private DoctorResponseDto doctor;
}
