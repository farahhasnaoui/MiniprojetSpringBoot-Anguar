package tn.esprit.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.reposotiries.DepartmentRepoitory;

import java.util.List;

@Service
public class IDepartmentServiceIMP implements departmentService {

    @Autowired
    DepartmentRepoitory departmentRepository;

    @Override
    public Departement addDepartement(Departement d){
        return departmentRepository.save(d);
    }
    @Override
    public Departement updateDepartement(Departement d) {
        return departmentRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDep) {
        return departmentRepository.findById(idDep).orElse(null);
    }

    @Override
    public List<Departement> retrieveAllDepartement() {
        return departmentRepository.findAll() ;
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {


    }

    @Override
    public void removeDepartment(Integer idDep) {

    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        return null;
    }

}
