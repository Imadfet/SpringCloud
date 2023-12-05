package com.lab.inscription.inscription;

import com.lab.inscription.inscription.dto.InscriptionDTO;
import com.lab.inscription.inscription.services.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class InscriptionApplication {

	@Autowired
	private InscriptionService inscriptionService;

	@Bean
	public CommandLineRunner console() {
		return (args) -> {
			// Ajouter des inscriptions de test lors du démarrage de l'application
			InscriptionDTO inscriptionDTO1 = new InscriptionDTO();
			inscriptionDTO1.setIdCours(1L);
			inscriptionDTO1.setIdEtudiant(1L);

			InscriptionDTO inscriptionDTO2 = new InscriptionDTO();
			inscriptionDTO2.setIdCours(1L); // Use the same course ID
			inscriptionDTO2.setIdEtudiant(2L); // Different student

			InscriptionDTO inscriptionDTO3 = new InscriptionDTO();
			inscriptionDTO3.setIdCours(2L); // Different course ID
			inscriptionDTO3.setIdEtudiant(1L); // Use the same student ID

			inscriptionService.createInscription(inscriptionDTO1);
			inscriptionService.createInscription(inscriptionDTO2);
			inscriptionService.createInscription(inscriptionDTO3);

			// Vous pouvez ajouter d'autres données de test ici
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(InscriptionApplication.class, args);
	}
}
