package com.lab.inscription.inscription.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCours;
    private Long idEtudiant;

    public Inscription() {
    }

    public Inscription(Long idCours, Long idEtudiant) {
        this.idCours = idCours;
        this.idEtudiant = idEtudiant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCours() {
        return idCours;
    }

    public void setIdCours(Long idCours) {
        this.idCours = idCours;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "id=" + id +
                ", idCours=" + idCours +
                ", idEtudiant=" + idEtudiant +
                '}';
    }
}
