package com.lab.inscription.inscription.controllers;

import com.lab.inscription.inscription.dto.CoursDTO;
import com.lab.inscription.inscription.services.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("map")
public class MappingController {

    @Autowired
    MappingService mappingService;
    @GetMapping("/cour/{id}")
    public CoursDTO getCours(@PathVariable Long id){
        return mappingService.getCoursByInscription(id);
    }

    @GetMapping("/cour/etudiant/{id}")
    public List<CoursDTO> getCoursByEtudiant(@PathVariable Long id){
        return mappingService.getCoursByEtudiant(id);
    }


}
