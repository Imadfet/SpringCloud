package com.lab.cours.cour.repositories;

import com.lab.cours.cour.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {

}
