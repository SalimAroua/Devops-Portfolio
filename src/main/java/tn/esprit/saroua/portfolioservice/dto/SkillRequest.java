package tn.esprit.saroua.portfolioservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tn.esprit.saroua.portfolioservice.enums.SkillLevel;
import tn.esprit.saroua.portfolioservice.enums.SkillType;

public record SkillRequest(
        @NotBlank String name,
        @NotNull SkillLevel level,
        @NotNull SkillType type
) {}
