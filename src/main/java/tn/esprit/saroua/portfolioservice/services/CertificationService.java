package tn.esprit.saroua.portfolioservice.services;

import tn.esprit.saroua.portfolioservice.dto.CertificationRequest;
import tn.esprit.saroua.portfolioservice.dto.CertificationResponse;
import tn.esprit.saroua.portfolioservice.entities.Certification;
import tn.esprit.saroua.portfolioservice.exceptions.ResourceNotFoundException;
import tn.esprit.saroua.portfolioservice.mapper.CertificationMapper;
import tn.esprit.saroua.portfolioservice.repositories.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificationService {

    private final CertificationRepository repository;

    public CertificationResponse create(CertificationRequest request) {
        return CertificationMapper.toResponse(
                repository.save(CertificationMapper.toEntity(request))
        );
    }

    public List<CertificationResponse> getAll() {
        return repository.findAll().stream()
                .map(CertificationMapper::toResponse)
                .toList();
    }

    public CertificationResponse getById(String id) {
        Certification c = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Certification non trouvée avec l'ID: " + id));
        return CertificationMapper.toResponse(c);
    }

    public CertificationResponse update(String id, CertificationRequest request) {
        Certification c = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Certification non trouvée avec l'ID: " + id));
        CertificationMapper.updateEntity(c, request);
        return CertificationMapper.toResponse(repository.save(c));
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Certification non trouvée avec l'ID: " + id);
        }
        repository.deleteById(id);
    }
}
