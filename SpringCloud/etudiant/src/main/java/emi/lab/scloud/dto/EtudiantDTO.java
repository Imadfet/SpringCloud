package emi.lab.scloud.dto;

public class EtudiantDTO {
    private Long id;
    private String nom;
    private String prenom;



    public EtudiantDTO() {
    }

    public EtudiantDTO(Long id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }


}
