package tn.esprit.saroua.portfolioservice.dto;

import tn.esprit.saroua.portfolioservice.enums.SkillLevel;
import tn.esprit.saroua.portfolioservice.enums.SkillType;

public record SkillResponse(
        String id,
        String name,
        SkillLevel level,
        SkillType type
        // , String portfolioId
) {}
