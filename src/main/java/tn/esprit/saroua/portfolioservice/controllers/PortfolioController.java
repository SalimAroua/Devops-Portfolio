package tn.esprit.saroua.portfolioservice.controllers;

import org.springframework.http.HttpStatus;
import tn.esprit.saroua.portfolioservice.dto.PortfolioRequest;
import tn.esprit.saroua.portfolioservice.dto.PortfolioResponse;
import tn.esprit.saroua.portfolioservice.services.PortfolioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PortfolioController {

    private final PortfolioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PortfolioResponse create(@RequestBody PortfolioRequest request) {
        return service.create(request);
    }


    @GetMapping
    public ResponseEntity<List<PortfolioResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioResponse> update(@PathVariable String id, @Valid @RequestBody PortfolioRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
