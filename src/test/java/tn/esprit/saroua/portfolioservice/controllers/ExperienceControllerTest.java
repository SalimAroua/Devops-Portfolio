package tn.esprit.saroua.portfolioservice.controllers;

import tn.esprit.saroua.portfolioservice.services.ExperienceService;
import tn.esprit.saroua.portfolioservice.dto.ExperienceResponse;

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

@WebMvcTest(ExperienceController.class)
public class ExperienceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExperienceService experienceService;

    @Test
    void testGetAll() throws Exception {
        ExperienceResponse mockDto = new ExperienceResponse(
            "Software Engineer",
            "Google",
            "Mountain View",
            LocalDate.of(2022, 5, 1),
            LocalDate.of(2023, 5, 1),
            "Worked on search",
            List.of("Java", "Spring")
        );
        when(experienceService.getAllExperiences()).thenReturn(List.of(mockDto));

        mockMvc.perform(get("/api/experiences"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
