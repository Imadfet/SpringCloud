package com.lab.inscription.inscription.controllers;

import com.lab.inscription.inscription.dto.InscriptionDTO;
import com.lab.inscription.inscription.entity.Inscription;
import com.lab.inscription.inscription.services.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    @GetMapping
    public ResponseEntity<List<InscriptionDTO>> getAllInscriptions() {
        List<InscriptionDTO> inscriptions = inscriptionService.getAllInscriptions();
        return new ResponseEntity<>(inscriptions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscriptionDTO> getInscriptionById(@PathVariable Long id) {
        InscriptionDTO inscription = inscriptionService.getInscriptionById(id);

        if (inscription != null) {
            return new ResponseEntity<>(inscription, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<InscriptionDTO> createInscription(@RequestBody InscriptionDTO inscriptionDTO) {
        InscriptionDTO createdInscription = inscriptionService.createInscription(inscriptionDTO);
        return new ResponseEntity<>(createdInscription, HttpStatus.CREATED);
    }
    @PostMapping("/addins")
    public Inscription AddInscription(@RequestBody Inscription inscription){
        return inscriptionService.AddInscription(inscription);
    }

    // Ajoutez d'autres méthodes en fonction de vos besoins
}
