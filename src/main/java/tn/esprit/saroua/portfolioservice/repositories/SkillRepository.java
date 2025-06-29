package tn.esprit.saroua.portfolioservice.repositories;

import tn.esprit.saroua.portfolioservice.entities.Skill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends MongoRepository<Skill, String> {
}
