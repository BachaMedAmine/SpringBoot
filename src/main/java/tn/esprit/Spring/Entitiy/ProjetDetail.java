package tn.esprit.Spring.Entitiy;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class ProjetDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String technologie;
    private Long cout;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @ManyToOne
    @JoinColumn(name = "projet_id")
    private Projet projet;

    // Getters and Setters
}