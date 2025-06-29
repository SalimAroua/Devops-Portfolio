package tn.esprit.saroua.portfolioservice.repositories;

import tn.esprit.saroua.portfolioservice.entities.Portfolio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends MongoRepository<Portfolio, String> {
}
