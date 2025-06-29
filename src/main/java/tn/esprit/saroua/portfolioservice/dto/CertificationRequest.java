package tn.esprit.saroua.portfolioservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CertificationRequest(
        @NotBlank String name,
        @NotBlank String issuer,
        @NotNull LocalDate issueDate,
        LocalDate expirationDate,
        String credentialUrl
) {}
