package tn.esprit.saroua.portfolioservice.services;

import tn.esprit.saroua.portfolioservice.dto.SkillRequest;
import tn.esprit.saroua.portfolioservice.dto.SkillResponse;
import tn.esprit.saroua.portfolioservice.entities.Skill;
import tn.esprit.saroua.portfolioservice.exceptions.ResourceNotFoundException;
import tn.esprit.saroua.portfolioservice.mapper.SkillMapper;
import tn.esprit.saroua.portfolioservice.repositories.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository repository;

    public SkillResponse createSkill(SkillRequest request) {
        Skill skill = SkillMapper.toEntity(request);
        return SkillMapper.toResponse(repository.save(skill));
    }

    public List<SkillResponse> getAllSkills() {
        return repository.findAll().stream()
                .map(SkillMapper::toResponse)
                .toList();
    }

    public SkillResponse getSkillById(String id) {
        Skill skill = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compétence non trouvée avec l'ID: " + id));
        return SkillMapper.toResponse(skill);
    }

    public SkillResponse updateSkill(String id, SkillRequest request) {
        Skill skill = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compétence non trouvée avec l'ID: " + id));
        SkillMapper.updateEntity(skill, request);
        return SkillMapper.toResponse(repository.save(skill));
    }

    public void deleteSkill(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Compétence non trouvée avec l'ID: " + id);
        }
        repository.deleteById(id);
    }
}
