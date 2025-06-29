package tn.esprit.saroua.portfolioservice.dto;

import java.time.LocalDate;

public record CertificationResponse(
        String id,
        String name,
        String issuer,
        LocalDate issueDate,
        LocalDate expirationDate,
        String credentialUrl
) {}
