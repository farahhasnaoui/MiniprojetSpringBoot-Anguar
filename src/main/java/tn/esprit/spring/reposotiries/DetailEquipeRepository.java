package tn.esprit.spring.reposotiries;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.DetailEquipe;

import javax.transaction.Transactional;

@Transactional

public interface DetailEquipeRepository extends JpaRepository<DetailEquipe, Integer> {
}
