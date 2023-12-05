package com.lab.cours.cour.dto;

import java.time.LocalDate;

public class CoursDTO {

    private Long id;
    private String nomCours;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    // Constructeurs
    public CoursDTO() {
    }

    public CoursDTO(Long id, String nomCours, LocalDate dateDebut, LocalDate dateFin) {
        this.id = id;
        this.nomCours = nomCours;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
}

