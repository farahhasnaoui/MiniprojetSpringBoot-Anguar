package tn.esprit.spring.services;

import tn.esprit.spring.entity.Universite;

import java.util.List;

public  interface UniversiteService  {
    public Universite addUniversite(Universite u);
    public Universite updateUniversity(Universite u);
    public Universite retrieveUniversity(Integer idUni);
    public List<Universite> getAllUniversities();
    public void removeUniversity(Integer idUni);
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
