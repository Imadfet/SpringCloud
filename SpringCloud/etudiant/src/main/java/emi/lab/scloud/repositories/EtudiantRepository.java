package emi.lab.scloud.repositories;

import emi.lab.scloud.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    List<Etudiant> findByNom(String nom);
    List<Etudiant> findByPrenom(String prenom);
}
