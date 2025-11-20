package com.RaxPotter.hospitalManagementSystem;

import com.RaxPotter.hospitalManagementSystem.entity.Patient;
import com.RaxPotter.hospitalManagementSystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList;
        patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

}
