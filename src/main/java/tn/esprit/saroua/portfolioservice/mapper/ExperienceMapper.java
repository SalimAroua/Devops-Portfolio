package tn.esprit.saroua.portfolioservice.mapper;

import tn.esprit.saroua.portfolioservice.dto.ExperienceRequest;
import tn.esprit.saroua.portfolioservice.dto.ExperienceResponse;
import tn.esprit.saroua.portfolioservice.entities.Experience;

public class ExperienceMapper {

    public static Experience toEntity(ExperienceRequest dto) {
        return Experience.builder()
                .title(dto.title())
                .company(dto.company())
                .startDate(dto.startDate())
                .endDate(dto.endDate())
                .description(dto.description())
                .linkedProjectIds(dto.linkedProjectIds())
                .build();
    }

    public static void updateEntity(Experience entity, ExperienceRequest dto) {
        entity.setTitle(dto.title());
        entity.setCompany(dto.company());
        entity.setStartDate(dto.startDate());
        entity.setEndDate(dto.endDate());
        entity.setDescription(dto.description());
        entity.setLinkedProjectIds(dto.linkedProjectIds());
    }

    public static ExperienceResponse toResponse(Experience entity) {
        return new ExperienceResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getCompany(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getDescription(),
                entity.getLinkedProjectIds()
        );
    }
}
