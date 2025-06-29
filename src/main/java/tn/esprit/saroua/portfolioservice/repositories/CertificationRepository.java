package tn.esprit.saroua.portfolioservice.repositories;

import tn.esprit.saroua.portfolioservice.entities.Certification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends MongoRepository<Certification, String> {
}
