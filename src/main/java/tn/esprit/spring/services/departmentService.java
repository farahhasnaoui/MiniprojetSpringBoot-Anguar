package tn.esprit.spring.services;

import tn.esprit.spring.entity.Departement;

import java.util.List;


public interface departmentService {
    public Departement addDepartement(Departement dep);
    public Departement updateDepartement(Departement dep);
    public Departement retrieveDepartement(Integer idDep);
    public List<Departement> retrieveAllDepartement();
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
    public void removeDepartment(Integer  idDep);
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
