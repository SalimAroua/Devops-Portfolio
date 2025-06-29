package tn.esprit.saroua.portfolioservice.controllers;

import tn.esprit.saroua.portfolioservice.dto.CertificationRequest;
import tn.esprit.saroua.portfolioservice.dto.CertificationResponse;
import tn.esprit.saroua.portfolioservice.services.CertificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certifications")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CertificationController {

    private final CertificationService service;

    @PostMapping
    public ResponseEntity<CertificationResponse> create(@Valid @RequestBody CertificationRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<CertificationResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CertificationResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CertificationResponse> update(@PathVariable String id, @Valid @RequestBody CertificationRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
