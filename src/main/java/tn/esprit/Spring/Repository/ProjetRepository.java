package tn.esprit.Spring.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Spring.Entitiy.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
}
