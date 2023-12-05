package com.lab.inscription.inscription.services;

import com.lab.inscription.inscription.dto.CoursDTO;
import com.lab.inscription.inscription.dto.InscriptionDTO;
import com.lab.inscription.inscription.entity.Inscription;
import com.lab.inscription.inscription.repositories.InscriptionRepository;
import emi.lab.scloud.dto.EtudiantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MappingService {

    private String courService = "http://localhost:8081";

    private RestTemplate restTemplate;

    @Autowired
    private InscriptionRepository inscriptionRepository;

    private WebClient coursClient;

    public MappingService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
        this.coursClient = WebClient.create(courService);
    }

    /*public CoursDTO getCoursByInscription(Long inscriptionId){
        Optional<Inscription> inscription = inscriptionRepository.findById(inscriptionId);
        return this.restTemplate.getForObject(courService + "/cour/{id}" , CoursDTO.class, inscription.get().getIdCours() );
    }*/

    public CoursDTO getCoursByInscription(Long inscriptionId){
        Optional<Inscription> inscription = inscriptionRepository.findById(inscriptionId);
        return this.coursClient.get().uri("/cour/" + inscription.get().getIdCours()).retrieve().bodyToMono(CoursDTO.class).block();
    }
    public List<CoursDTO> getCoursByEtudiant(Long etudiantId) {
        List<Inscription> inscriptionList = inscriptionRepository.findByIdEtudiant(etudiantId);

        List<Mono<CoursDTO>> coursMonos = inscriptionList.stream()
                .map(inscription -> coursClient.get().uri("/cour/" + inscription.getIdCours())
                        .retrieve()
                        .bodyToMono(CoursDTO.class))
                .collect(Collectors.toList());

        return Flux.merge(coursMonos).collectList().block();
    }


}
