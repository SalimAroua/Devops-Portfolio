package tn.esprit.saroua.portfolioservice.services;

import tn.esprit.saroua.portfolioservice.dto.ExperienceRequest;
import tn.esprit.saroua.portfolioservice.dto.ExperienceResponse;
import tn.esprit.saroua.portfolioservice.entities.Experience;
import tn.esprit.saroua.portfolioservice.exceptions.ResourceNotFoundException;
import tn.esprit.saroua.portfolioservice.mapper.ExperienceMapper;
import tn.esprit.saroua.portfolioservice.repositories.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceService {

    private final ExperienceRepository repository;

    public ExperienceResponse createExperience(ExperienceRequest request) {
        Experience entity = ExperienceMapper.toEntity(request);
        return ExperienceMapper.toResponse(repository.save(entity));
    }

    public List<ExperienceResponse> getAllExperiences() {
        return repository.findAll().stream()
                .map(ExperienceMapper::toResponse)
                .toList();
    }

    public ExperienceResponse getExperienceById(String id) {
        Experience experience = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expérience non trouvée avec l'ID: " + id));
        return ExperienceMapper.toResponse(experience);
    }

    public ExperienceResponse updateExperience(String id, ExperienceRequest request) {
        Experience experience = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expérience non trouvée avec l'ID: " + id));
        ExperienceMapper.updateEntity(experience, request);
        return ExperienceMapper.toResponse(repository.save(experience));
    }

    public void deleteExperience(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Expérience non trouvée avec l'ID: " + id);
        }
        repository.deleteById(id);
    }
}
