package tn.esprit.saroua.portfolioservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "certifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certification {

    @Id
    private String id;

    private String name;
    private String issuer;
    private LocalDate issueDate;
    private LocalDate expirationDate;
    private String credentialUrl;
}
