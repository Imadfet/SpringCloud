package emi.lab.scloud.services;

import emi.lab.scloud.entity.Etudiant;
import emi.lab.scloud.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public List<Etudiant> findEtudiantsByNom(String nom) {
        return etudiantRepository.findByNom(nom);
    }

    public List<Etudiant> findEtudiantsByPrenom(String prenom) {
        return etudiantRepository.findByPrenom(prenom);
    }

    public boolean getEtudExist(Long id){
        return etudiantRepository.existsById(id);
    }

}
