package tn.esprit.saroua.portfolioservice.controllers;

import tn.esprit.saroua.portfolioservice.dto.*;
import tn.esprit.saroua.portfolioservice.services.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExperienceController {

    private final ExperienceService service;

    @PostMapping
    public ResponseEntity<ExperienceResponse> create(@Valid @RequestBody ExperienceRequest request) {
        return ResponseEntity.ok(service.createExperience(request));
    }

    @GetMapping
    public ResponseEntity<List<ExperienceResponse>> getAll() {
        return ResponseEntity.ok(service.getAllExperiences());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getExperienceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceResponse> update(
            @PathVariable String id,
            @Valid @RequestBody ExperienceRequest request) {
        return ResponseEntity.ok(service.updateExperience(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteExperience(id);
        return ResponseEntity.noContent().build();
    }
}
