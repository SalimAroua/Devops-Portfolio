package tn.esprit.saroua.portfolioservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record PortfolioRequest(
        @NotBlank String bio,
        @NotBlank @Email String email,
        String photoUrl,
        @Size(max = 5) List<String> contactLinks
) {}
