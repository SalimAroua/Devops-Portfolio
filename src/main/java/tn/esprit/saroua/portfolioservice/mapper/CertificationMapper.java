package tn.esprit.saroua.portfolioservice.mapper;

import tn.esprit.saroua.portfolioservice.dto.CertificationRequest;
import tn.esprit.saroua.portfolioservice.dto.CertificationResponse;
import tn.esprit.saroua.portfolioservice.entities.Certification;

public class CertificationMapper {

    public static Certification toEntity(CertificationRequest dto) {
        return Certification.builder()
                .name(dto.name())
                .issuer(dto.issuer())
                .issueDate(dto.issueDate())
                .expirationDate(dto.expirationDate())
                .credentialUrl(dto.credentialUrl())
                .build();
    }

    public static void updateEntity(Certification cert, CertificationRequest dto) {
        cert.setName(dto.name());
        cert.setIssuer(dto.issuer());
        cert.setIssueDate(dto.issueDate());
        cert.setExpirationDate(dto.expirationDate());
        cert.setCredentialUrl(dto.credentialUrl());
    }

    public static CertificationResponse toResponse(Certification cert) {
        return new CertificationResponse(
                cert.getId(),
                cert.getName(),
                cert.getIssuer(),
                cert.getIssueDate(),
                cert.getExpirationDate(),
                cert.getCredentialUrl()
        );
    }
}
