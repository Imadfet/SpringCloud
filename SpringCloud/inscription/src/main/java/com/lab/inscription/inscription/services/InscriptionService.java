package com.lab.inscription.inscription.services;

import com.lab.inscription.inscription.dto.InscriptionDTO;
import com.lab.inscription.inscription.entity.Inscription;
import com.lab.inscription.inscription.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    RestTemplate restTemplate = new RestTemplate();

    String coursUrl = "http://localhost:8081/getcours";

    String etudUrl = "http://localhost:8080/getetudexistance";

    public List<InscriptionDTO> getAllInscriptions() {
        return inscriptionRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public InscriptionDTO getInscriptionById(Long id) {
        Inscription inscription = inscriptionRepository.findById(id).orElse(null);
        return (inscription != null) ? convertToDto(inscription) : null;
    }

    public InscriptionDTO createInscription(InscriptionDTO inscriptionDTO) {
        Inscription inscription = convertToEntity(inscriptionDTO);
        inscription = inscriptionRepository.save(inscription);
        return convertToDto(inscription);
    }

    // Ajoutez d'autres méthodes en fonction de vos besoins

    private InscriptionDTO convertToDto(Inscription inscription) {
        InscriptionDTO inscriptionDTO = new InscriptionDTO();
        inscriptionDTO.setId(inscription.getId());
        inscriptionDTO.setIdCours(inscription.getIdCours());
        inscriptionDTO.setIdEtudiant(inscription.getIdEtudiant());
        return inscriptionDTO;
    }

    private Inscription convertToEntity(InscriptionDTO inscriptionDTO) {
        Inscription inscription = new Inscription();
        inscription.setIdCours(inscriptionDTO.getIdCours());
        inscription.setIdEtudiant(inscriptionDTO.getIdEtudiant());
        return inscription;
    }

    public Inscription AddInscription(Inscription inscription) {
        ResponseEntity<Boolean> responseCourEntity = restTemplate.getForEntity(coursUrl + "/" + inscription.getIdCours(), Boolean.class);
        ResponseEntity<Boolean> responseEtudiantEntity = restTemplate.getForEntity(etudUrl + "/" + inscription.getIdEtudiant(), Boolean.class);

        boolean response = responseCourEntity.getBody() && responseEtudiantEntity.getBody();

        if (response) {
            inscriptionRepository.save(inscription);
            return inscription;
        } else {
            System.out.println("Cours ou etudiant inexistant");
        }
        return inscription;
    }
}
