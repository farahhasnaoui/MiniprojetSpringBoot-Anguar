package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Universite;
import tn.esprit.spring.reposotiries.DepartmentRepoitory;
import tn.esprit.spring.reposotiries.UniversiteRepository;

import java.util.List;
@Service
public class IUniversityServiceIMP  implements UniversiteService{
    @Autowired
    UniversiteRepository universityrepository ;
    @Autowired
    DepartmentRepoitory departementeepository;


    @Override
    public Universite addUniversite(Universite u) {
        return universityrepository.save(u);
    }

    @Override
    public Universite updateUniversity(Universite u) {
        return universityrepository.save(u);
    }

    @Override
    public Universite retrieveUniversity(Integer idUni) {
        return universityrepository.findById(idUni).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversities() {
        return universityrepository.findAll();
    }

    @Override
    public void removeUniversity(Integer idUni) {
        universityrepository.deleteById(idUni);

    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universite = universityrepository.findById(idUniversite).orElse(null);
        Departement departement = departementeepository.findById(idDepartement).orElse(null);
        if(universite != null && departement != null){
            //int Salaire = emp.getSalaire()+200
            //emp.SetSalaire(salire) // exple hdha aal faza
            universite.getDepartments().add(departement);
            universityrepository.save(universite);
        }

    }
}
