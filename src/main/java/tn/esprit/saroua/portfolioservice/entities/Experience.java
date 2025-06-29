package tn.esprit.saroua.portfolioservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "experiences")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Experience {

    @Id
    private String id;

    private String title;

    private String company;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    private List<String> linkedProjectIds; // Optional cross-service reference
}
