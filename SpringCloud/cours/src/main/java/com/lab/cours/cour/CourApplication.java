package com.lab.cours.cour;

import com.lab.cours.cour.dto.CoursDTO;
import com.lab.cours.cour.services.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication
public class CourApplication {

	@Autowired
	private CoursService coursService;

	@Bean
	public CommandLineRunner console() {
		return (args) -> {
			// Ajouter un cours de test lors du démarrage de l'application
			CoursDTO coursDTO = new CoursDTO();
			coursDTO.setNomCours("Cours de Test");
			coursDTO.setDateDebut(LocalDate.of(2023, 3, 1));
			coursDTO.setDateFin(LocalDate.of(2023, 11, 4));
			CoursDTO coursDTO2 = new CoursDTO();
			coursDTO.setNomCours("Cours d'analyse");
			coursDTO.setDateDebut(LocalDate.of(2023, 4, 1));
			coursDTO.setDateFin(LocalDate.of(2023, 12, 23));
			CoursDTO coursDTO3 = new CoursDTO();
			coursDTO.setNomCours("Cours de math");
			coursDTO.setDateDebut(LocalDate.of(2023, 1, 1));
			coursDTO.setDateFin(LocalDate.of(2023, 12, 31));
			coursService.createCours(coursDTO);

			// Vous pouvez ajouter d'autres données de test ici
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(CourApplication.class, args);
	}

}
