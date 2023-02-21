package tn.esprit.spring.reposotiries;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Contrat;

import java.sql.Date;
import java.util.List;


public  interface ContratRepository  extends JpaRepository<Contrat, Integer> {

}
