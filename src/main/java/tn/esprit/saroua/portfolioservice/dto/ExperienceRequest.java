package tn.esprit.saroua.portfolioservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record ExperienceRequest(
        @NotBlank String title,
        @NotBlank String company,
        @NotNull LocalDate startDate,
        LocalDate endDate,
        String description,
        List<String> linkedProjectIds
) {}
