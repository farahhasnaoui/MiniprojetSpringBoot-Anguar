package tn.esprit.spring.reposotiries;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entity.Etudiant;

import java.util.List;

public  interface EtudiantRepository extends JpaRepository <Etudiant, Integer> {
    public List<Etudiant> findEtudiantsByDepartementIdDepartement(int idDepartement);

}
