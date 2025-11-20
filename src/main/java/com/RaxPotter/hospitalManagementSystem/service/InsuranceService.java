package com.RaxPotter.hospitalManagementSystem.service;

import com.RaxPotter.hospitalManagementSystem.dto.PatientDTO;
import com.RaxPotter.hospitalManagementSystem.entity.Insurance;
import com.RaxPotter.hospitalManagementSystem.entity.Patient;
import com.RaxPotter.hospitalManagementSystem.repository.InsuranceRepository;
import com.RaxPotter.hospitalManagementSystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public PatientDTO assignInsuranceToPatient (Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("Patient not found with patient Id : " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);

        return modelMapper.map(patient, PatientDTO.class);
    }

    @Transactional
    public PatientDTO dissociateInsuranceFromPatient (Long patientId) {

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("patient not found with patient Id : "+ patientId));

        patient.setInsurance(null);

        return modelMapper.map(patient, PatientDTO.class);
    }
}
