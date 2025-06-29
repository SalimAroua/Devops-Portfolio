package tn.esprit.saroua.portfolioservice.services;

import tn.esprit.saroua.portfolioservice.dto.PortfolioRequest;
import tn.esprit.saroua.portfolioservice.dto.PortfolioResponse;
import tn.esprit.saroua.portfolioservice.entities.Portfolio;
import tn.esprit.saroua.portfolioservice.exceptions.ResourceNotFoundException;
import tn.esprit.saroua.portfolioservice.mapper.PortfolioMapper;
import tn.esprit.saroua.portfolioservice.repositories.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository repository;

    public PortfolioResponse create(PortfolioRequest request) {
        Portfolio portfolio = PortfolioMapper.toEntity(request);
        return PortfolioMapper.toResponse(repository.save(portfolio));
    }

    public List<PortfolioResponse> getAll() {
        return repository.findAll().stream()
                .map(PortfolioMapper::toResponse)
                .toList();
    }

    public PortfolioResponse getById(String id) {
        Portfolio p = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio non trouvé avec l'ID: " + id));
        return PortfolioMapper.toResponse(p);
    }

    public PortfolioResponse update(String id, PortfolioRequest request) {
        Portfolio p = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Portfolio non trouvé avec l'ID: " + id));
        PortfolioMapper.updateEntity(p, request);
        return PortfolioMapper.toResponse(repository.save(p));
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Portfolio non trouvé avec l'ID: " + id);
        }
        repository.deleteById(id);
    }
}
