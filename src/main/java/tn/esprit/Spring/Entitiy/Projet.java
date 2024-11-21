package tn.esprit.Spring.Entitiy;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sujet; // Make sure this field exists!

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    private List<ProjetDetail> projetDetails;

    @ManyToMany
    @JoinTable(
            name = "equipe_projet",
            joinColumns = @JoinColumn(name = "projet_id"),
            inverseJoinColumns = @JoinColumn(name = "equipe_id")
    )
    private List<Equipe> equipes;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public List<ProjetDetail> getProjetDetails() {
        return projetDetails;
    }

    public void setProjetDetails(List<ProjetDetail> projetDetails) {
        this.projetDetails = projetDetails;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }
}
