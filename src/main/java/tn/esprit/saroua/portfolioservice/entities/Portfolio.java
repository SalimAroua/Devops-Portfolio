package tn.esprit.saroua.portfolioservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "portfolios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Portfolio {

    @Id
    private String id;

    private String bio;

    private String email;

    private String photoUrl;

    private List<String> contactLinks;

    // private String userId; // TODO: re-enable if user-service is added
}
