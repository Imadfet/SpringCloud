package com.lab.cours.cour.services;

import com.lab.cours.cour.dto.CoursDTO;
import com.lab.cours.cour.entity.Cours;
import com.lab.cours.cour.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;

    public List<CoursDTO> getAllCours() {
        return coursRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CoursDTO getCoursById(Long id) {
        Cours cours = coursRepository.findById(id).orElse(null);
        return (cours != null) ? convertToDto(cours) : null;
    }

    public CoursDTO createCours(CoursDTO coursDTO) {
        Cours cours = convertToEntity(coursDTO);
        cours = coursRepository.save(cours);
        return convertToDto(cours);
    }

    // Ajoutez d'autres méthodes en fonction de vos besoins

    private CoursDTO convertToDto(Cours cours) {
        CoursDTO coursDTO = new CoursDTO();
        coursDTO.setId(cours.getId());
        coursDTO.setNomCours(cours.getNomCours());
        coursDTO.setDateDebut(cours.getDateDebut());
        coursDTO.setDateFin(cours.getDateFin());
        return coursDTO;
    }

    private Cours convertToEntity(CoursDTO coursDTO) {
        Cours cours = new Cours();
        cours.setNomCours(coursDTO.getNomCours());
        cours.setDateDebut(coursDTO.getDateDebut());
        cours.setDateFin(coursDTO.getDateFin());
        return cours;
    }

//    public void inscrireEtudiantDansCours(Long idCours, Long idEtudiant) {
//        // Vérifier que le cours existe
//        //Cours cours = coursRepository.findById(idCours).orElseThrow(() -> new ChangeSetPersister.NotFoundException("Cours non trouvé avec l'ID : " + idCours));
//
//        // Utiliser WebClient pour appeler le service Etudiant et inscrire l'étudiant
//        webClientBuilder.build()
//                .post()
//                .uri("http://etudiant-service/etudiants/inscription")
//                .bodyValue(inscriptionDTO)
//                .retrieve()
//                .toBodilessEntity()
//                .block();
//    }

    public boolean getCourExist(Long id){
        return coursRepository.existsById(id);
    }




}
