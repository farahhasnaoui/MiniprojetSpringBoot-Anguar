package tn.esprit.spring.services;



import tn.esprit.spring.entity.Etudiant;

import java.util.List;

public interface etudiantService {
    public Etudiant addStudent(Etudiant e);
    public Etudiant updateStudent(Etudiant e);
    public Etudiant getById(Integer idEtudiant);
    public List<Etudiant> getAllStudent();
    public void removeEtudiant(Integer idEtudiant);
    public void addAndAssignEtudiant (Integer etudiantId,Integer depId);

    public Etudiant AssignEtudiantToEquipeAndContrat(Etudiant e , Integer idContrat , Integer idEquipe);

    public  List <Etudiant> getEtudiantsByDepartement (Integer idDepartement);





}
