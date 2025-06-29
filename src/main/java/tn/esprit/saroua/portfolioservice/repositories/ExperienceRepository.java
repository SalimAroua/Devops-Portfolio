package tn.esprit.saroua.portfolioservice.repositories;

import tn.esprit.saroua.portfolioservice.entities.Experience;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends MongoRepository<Experience, String> {
}
