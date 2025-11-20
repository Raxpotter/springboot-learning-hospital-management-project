package com.RaxPotter.hospitalManagementSystem.service;

import com.RaxPotter.hospitalManagementSystem.dto.AppointmentDTO;
import com.RaxPotter.hospitalManagementSystem.entity.Appointment;
import com.RaxPotter.hospitalManagementSystem.entity.Doctor;
import com.RaxPotter.hospitalManagementSystem.entity.Patient;
import com.RaxPotter.hospitalManagementSystem.repository.AppointmentRepository;
import com.RaxPotter.hospitalManagementSystem.repository.DoctorRepository;
import com.RaxPotter.hospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public AppointmentDTO createNewAppointment (Appointment appointment, Long doctorId, Long patientId){

        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("appointment can't made");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);
        doctor.getAppointments().add(appointment);

        appointmentRepository.save(appointment);

        return modelMapper.map(appointment, AppointmentDTO.class);
    }

    @Transactional
    public AppointmentDTO reassignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId){

        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById((doctorId)).orElseThrow();

        appointment.setDoctor(doctor);

        doctor.getAppointments().add(appointment);

        return modelMapper.map(appointment, AppointmentDTO.class);
    }




}
