package tn.esprit.saroua.portfolioservice.mapper;

import tn.esprit.saroua.portfolioservice.dto.PortfolioRequest;
import tn.esprit.saroua.portfolioservice.dto.PortfolioResponse;
import tn.esprit.saroua.portfolioservice.entities.Portfolio;

public class PortfolioMapper {

    public static Portfolio toEntity(PortfolioRequest dto) {
        return Portfolio.builder()
                .bio(dto.bio())
                .email(dto.email())
                .photoUrl(dto.photoUrl())
                .contactLinks(dto.contactLinks())
                .build();
    }

    public static void updateEntity(Portfolio portfolio, PortfolioRequest dto) {
        portfolio.setBio(dto.bio());
        portfolio.setEmail(dto.email());
        portfolio.setPhotoUrl(dto.photoUrl());
        portfolio.setContactLinks(dto.contactLinks());
    }

    public static PortfolioResponse toResponse(Portfolio portfolio) {
        return new PortfolioResponse(
                portfolio.getId(),
                portfolio.getBio(),
                portfolio.getEmail(),
                portfolio.getPhotoUrl(),
                portfolio.getContactLinks()
        );
    }
}
