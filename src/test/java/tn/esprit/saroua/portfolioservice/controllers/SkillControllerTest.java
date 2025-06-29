package tn.esprit.saroua.portfolioservice.controllers;

import tn.esprit.saroua.portfolioservice.services.SkillService;
import tn.esprit.saroua.portfolioservice.dto.SkillResponse;
import tn.esprit.saroua.portfolioservice.enums.SkillLevel;
import tn.esprit.saroua.portfolioservice.enums.SkillType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SkillController.class)
public class SkillControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SkillService skillService;

    @Test
    void testGetAll() throws Exception {
        SkillResponse mockDto = new SkillResponse(
                "Java",
                "Backend development",
                SkillLevel.EXPERT,
                SkillType.BACKEND
        );

        when(skillService.getAllSkills()).thenReturn(List.of(mockDto));

        mockMvc.perform(get("/api/skills"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value("Java"))
                .andExpect(jsonPath("$[0].name").value("Backend development"))
                .andExpect(jsonPath("$[0].level").value("EXPERT"))
                .andExpect(jsonPath("$[0].type").value("BACKEND"));
    }
}
