package tn.esprit.saroua.portfolioservice.mapper;

import tn.esprit.saroua.portfolioservice.dto.SkillRequest;
import tn.esprit.saroua.portfolioservice.dto.SkillResponse;
import tn.esprit.saroua.portfolioservice.entities.Skill;

public class SkillMapper {

    public static Skill toEntity(SkillRequest dto) {
        return Skill.builder()
                .name(dto.name())
                .level(dto.level())
                .type(dto.type())
                .build();
    }

    public static void updateEntity(Skill entity, SkillRequest dto) {
        entity.setName(dto.name());
        entity.setLevel(dto.level());
        entity.setType(dto.type());
    }

    public static SkillResponse toResponse(Skill skill) {
        return new SkillResponse(
                skill.getId(),
                skill.getName(),
                skill.getLevel(),
                skill.getType()
        );
    }
}
