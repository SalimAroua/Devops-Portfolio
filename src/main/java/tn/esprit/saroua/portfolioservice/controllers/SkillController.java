package tn.esprit.saroua.portfolioservice.controllers;

import tn.esprit.saroua.portfolioservice.dto.SkillRequest;
import tn.esprit.saroua.portfolioservice.dto.SkillResponse;
import tn.esprit.saroua.portfolioservice.services.SkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SkillController {

    private final SkillService service;

    @PostMapping
    public ResponseEntity<SkillResponse> create(@Valid @RequestBody SkillRequest request) {
        return ResponseEntity.ok(service.createSkill(request));
    }

    @GetMapping
    public ResponseEntity<List<SkillResponse>> getAll() {
        return ResponseEntity.ok(service.getAllSkills());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getSkillById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillResponse> update(@PathVariable String id, @Valid @RequestBody SkillRequest request) {
        return ResponseEntity.ok(service.updateSkill(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteSkill(id);
        return ResponseEntity.noContent().build();
    }
}
