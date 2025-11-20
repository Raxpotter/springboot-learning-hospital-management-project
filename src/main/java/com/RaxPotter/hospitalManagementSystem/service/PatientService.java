package com.RaxPotter.hospitalManagementSystem.service;

import com.RaxPotter.hospitalManagementSystem.dto.PatientDTO;
import com.RaxPotter.hospitalManagementSystem.entity.Patient;
import com.RaxPotter.hospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public PatientDTO getPatientById (Long id) {

        Patient patient =  patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("patient not found"));

        return modelMapper.map(patient, PatientDTO.class);
    }

    @Transactional
    public PatientDTO getPatientByName (String name){
        Patient patient =  patientRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("patient not found"));

        return modelMapper.map(patient, PatientDTO.class);
    }

    @Transactional
    public PatientDTO getPatientByEmail (String email){
        Patient patient =  patientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("patient not found"));

        return modelMapper.map(patient, PatientDTO.class);
    }

    @Transactional
    public PatientDTO getPatientByNameAndEmail (String name, String email){
        Patient patient =  patientRepository.findByNameAndEmail(name, email)
                .orElseThrow(() -> new RuntimeException("patient not found"));

        return modelMapper.map(patient, PatientDTO.class);
    }
}
