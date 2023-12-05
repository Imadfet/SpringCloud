package emi.lab.scloud.controllers;

import emi.lab.scloud.entity.Etudiant;
import emi.lab.scloud.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        return new ResponseEntity<List<Etudiant>>(etudiants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);

        if (etudiant != null) {
            return new ResponseEntity<>(etudiant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant createdEtudiant = etudiantService.createEtudiant(etudiant);
        return new ResponseEntity<>(createdEtudiant, HttpStatus.CREATED);
    }

    @GetMapping("/rechercher")
    public ResponseEntity<List<Etudiant>> findEtudiantsByNom(@RequestParam String nom) {
        List<Etudiant> etudiants = etudiantService.findEtudiantsByNom(nom);
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @GetMapping("/getetudexistance/{id}")
    public boolean getetudExist(@PathVariable Long id){
        return etudiantService.getEtudExist(id);
    }

}
