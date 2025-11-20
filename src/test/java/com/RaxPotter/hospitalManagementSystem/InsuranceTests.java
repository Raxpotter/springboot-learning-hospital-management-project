package com.RaxPotter.hospitalManagementSystem;

import com.RaxPotter.hospitalManagementSystem.dto.PatientDTO;
import com.RaxPotter.hospitalManagementSystem.entity.Insurance;
import com.RaxPotter.hospitalManagementSystem.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void addInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("ICICI00981")
                .provider("ICICI Life Insurance")
                .validTill(LocalDate.of(2030,12,31))
                .build();

        PatientDTO patient = insuranceService.assignInsuranceToPatient(insurance, 2L);

        System.out.println("After assigning insurance: " + patient);

        PatientDTO updatedPatient = insuranceService.dissociateInsuranceFromPatient(patient.getId());

        System.out.println("After removing insurance: " + updatedPatient);
    }

}
