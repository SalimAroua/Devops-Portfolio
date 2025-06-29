package tn.esprit.saroua.portfolioservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectReference {
    private String id;
    private String title;
    private String status; // Optional if you want to show it
}
