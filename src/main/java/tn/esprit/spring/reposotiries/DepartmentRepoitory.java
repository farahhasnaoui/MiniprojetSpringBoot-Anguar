package tn.esprit.spring.reposotiries;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Departement;

public interface  DepartmentRepoitory extends JpaRepository<Departement, Integer> {

}
