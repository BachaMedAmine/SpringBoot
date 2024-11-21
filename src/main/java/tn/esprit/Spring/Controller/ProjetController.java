package tn.esprit.Spring.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Spring.Entitiy.Projet;
import tn.esprit.Spring.Services.ProjetService;

import java.util.List;

@RestController
@RequestMapping("/projets")
public class ProjetController {
    private final ProjetService projetService;

    public ProjetController(ProjetService projetService) {
        this.projetService = projetService;
    }

    @GetMapping
    public List<Projet> getAllProjets() {
        return projetService.getAllProjets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable Long id) {
        return ResponseEntity.ok(projetService.getProjetById(id));
    }

    @CrossOrigin(origins = "http://localhost:3000") // Allows cross-origin requests from the specified URL
    @PostMapping  // Maps this method to handle POST requests on the /projets endpoint
    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) {
        Projet savedProjet = projetService.createProjet(projet);
        return ResponseEntity.ok(savedProjet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projet> updateProjet(@PathVariable Long id, @RequestBody Projet projet) {
        return ResponseEntity.ok(projetService.updateProjet(id, projet));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
        projetService.deleteProjet(id);
        return ResponseEntity.noContent().build();
    }
}
