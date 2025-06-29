package tn.esprit.saroua.portfolioservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import tn.esprit.saroua.portfolioservice.enums.*;

@Document(collection = "skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skill {

    @Id
    private String id;

    private String name;

    private SkillLevel level;

    private SkillType type;

    // private String portfolioId; // optional for future linking
}
