package tn.esprit.saroua.portfolioservice.controllers;

import tn.esprit.saroua.portfolioservice.services.CertificationService;
import tn.esprit.saroua.portfolioservice.dto.CertificationResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CertificationController.class)
public class CertificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CertificationService certificationService;

    @Test
    void testGetAll() throws Exception {
        CertificationResponse mockDto = new CertificationResponse(
            "AWS Certified",
            "Amazon",
            "12345",
            LocalDate.of(2023, 1, 1),
            LocalDate.of(2025, 1, 1),
            "Cloud certification"
        );
        when(certificationService.getAll()).thenReturn(List.of(mockDto));

        mockMvc.perform(get("/api/certifications"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
