package tn.esprit.saroua.portfolioservice.dto;

import java.util.List;

public record PortfolioResponse(
        String id,
        String bio,
        String email,
        String photoUrl,
        List<String> contactLinks
        // , String userId // optional for future
) {}
