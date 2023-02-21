package tn.esprit.spring.reposotiries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.Models.CountType;
import tn.esprit.spring.entity.Equipe;

import javax.transaction.Transactional;
import java.util.List;
@Transactional

public interface EquipeReposirory extends JpaRepository<Equipe,Integer> {
    List<Equipe> findEquipesByNomEquipe( );
}
