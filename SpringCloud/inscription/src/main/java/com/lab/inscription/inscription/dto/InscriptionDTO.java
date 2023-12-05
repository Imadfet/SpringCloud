package com.lab.inscription.inscription.dto;

public class InscriptionDTO {

    private Long id;
    private Long idCours;
    private Long idEtudiant;

    public InscriptionDTO() {
    }

    public InscriptionDTO(Long idCours, Long idEtudiant) {
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
}
