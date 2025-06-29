package tn.esprit.saroua.portfolioservice.dto;

import java.time.LocalDate;
import java.util.List;

public record ExperienceResponse(
        String id,
        String title,
        String company,
        LocalDate startDate,
        LocalDate endDate,
        String description,
        List<String> linkedProjectIds
) {}
