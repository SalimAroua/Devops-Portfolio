package tn.esprit.saroua.portfolioservice.controllers;

import tn.esprit.saroua.portfolioservice.services.PortfolioService;
import tn.esprit.saroua.portfolioservice.dto.PortfolioResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PortfolioController.class)
public class PortfolioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PortfolioService portfolioService;

    @Test
    void testGetAll() throws Exception {
        PortfolioResponse mockDto = new PortfolioResponse(
                "John Doe",                  // id
                "Senior Java Developer",     // bio
                "john.doe@example.com",      // email
                "https://example.com/photo.jpg", // photoUrl
                List.of("https://linkedin.com/in/johndoe", "https://github.com/johndoe") // contactLinks
        );

        when(portfolioService.getAll()).thenReturn(List.of(mockDto));

        mockMvc.perform(get("/api/portfolio"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value("John Doe"))
                .andExpect(jsonPath("$[0].bio").value("Senior Java Developer"))
                .andExpect(jsonPath("$[0].email").value("john.doe@example.com"))
                .andExpect(jsonPath("$[0].photoUrl").value("https://example.com/photo.jpg"))
                .andExpect(jsonPath("$[0].contactLinks").isArray());
    }
}
