package com.lab.inscription.inscription.repositories;

import com.lab.inscription.inscription.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    void findByIdCours(Long courId);

    List<Inscription> findByIdEtudiant(Long etudiantId);
}
