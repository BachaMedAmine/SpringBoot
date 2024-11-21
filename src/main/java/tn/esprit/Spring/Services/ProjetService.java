package tn.esprit.Spring.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Spring.Entitiy.Projet;
import tn.esprit.Spring.Repository.ProjetRepository;
import tn.esprit.Spring.Repository.EquipeRepository;

import tn.esprit.Spring.Entitiy.Equipe;  // Make sure this is the correct import

import java.util.List;

@Service
public class ProjetService {
    private final ProjetRepository projetRepository;
    @Autowired
    private EquipeRepository equipeRepository;

    public ProjetService(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    public List<Projet> getAllProjets() {
        return projetRepository.findAll();
    }

    public Projet getProjetById(Long id) {
        return projetRepository.findById(id).orElseThrow(() -> new RuntimeException("Projet not found"));
    }

    public Projet createProjet(Projet projet) {
        projet.getEquipes().forEach(equipe -> {
            // Now use the instance of equipeRepository to call existsById
            if (equipe.getId() == null || !equipeRepository.existsById(equipe.getId())) {
                equipeRepository.save(equipe);
            }
        });
        return projetRepository.save(projet);
    }

    public Projet updateProjet(Long id, Projet updatedProjet) {
        Projet projet = getProjetById(id);
        projet.setSujet(updatedProjet.getSujet());
        return projetRepository.save(projet);
    }

    public void deleteProjet(Long id) {
        projetRepository.deleteById(id);
    }
}
