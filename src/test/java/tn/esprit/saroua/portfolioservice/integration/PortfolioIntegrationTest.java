package tn.esprit.saroua.portfolioservice.integration;

import tn.esprit.saroua.portfolioservice.dto.PortfolioRequest;
import tn.esprit.saroua.portfolioservice.repositories.PortfolioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test") // ✅ Indique à Spring d'utiliser application-test.yml
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PortfolioIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PortfolioRepository repository;

    private WebTestClient client;

    @BeforeEach
    void setup() {
        client = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
        repository.deleteAll(); // ou .block() si MongoReactive
    }

    @Test
    void testCreateAndFetchPortfolio() {
        PortfolioRequest request = new PortfolioRequest(
                "Test bio",
                "test@example.com",
                "https://photo.jpg",
                List.of("https://github.com/test")
        );

        client.post().uri("/api/portfolio")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isCreated();

        client.get().uri("/api/portfolio")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].email").isEqualTo("test@example.com");
    }
}
