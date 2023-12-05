package com.lab.cours.cour.controllers;

import com.lab.cours.cour.dto.CoursDTO;
import com.lab.cours.cour.services.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cour")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @GetMapping
    public ResponseEntity<List<CoursDTO>> getAllCours() {
        List<CoursDTO> cours = coursService.getAllCours();
        return new ResponseEntity<>(cours, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoursDTO> getCoursById(@PathVariable Long id) {
        CoursDTO cours = coursService.getCoursById(id);

        if (cours != null) {
            return new ResponseEntity<>(cours, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CoursDTO> createCours(@RequestBody CoursDTO coursDTO) {
        CoursDTO createdCours = coursService.createCours(coursDTO);
        return new ResponseEntity<>(createdCours, HttpStatus.CREATED);
    }

    @GetMapping("/getcours/{id}")
    public boolean getCourExist(@PathVariable Long id){
        return coursService.getCourExist(id);
    }


}
