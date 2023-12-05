package emi.lab.scloud;

import emi.lab.scloud.entity.Etudiant;
import emi.lab.scloud.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class ScloudApplication {

	@Autowired
	private EtudiantRepository etudiantRepository;
	@Bean
	public CommandLineRunner console(){
		return (args)->{

			Etudiant etudiant = new Etudiant();
			etudiant.setNom("Chaoui mzabi");
			etudiant.setPrenom("Younes");
			Etudiant etudiant2 = new Etudiant();
			etudiant2.setNom("FETTAH");
			etudiant2.setPrenom("Imadeddine");



			etudiantRepository.save(etudiant);
			etudiantRepository.save(etudiant2);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ScloudApplication.class, args);
	}

}
