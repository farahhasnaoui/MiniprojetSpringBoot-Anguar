package tn.esprit.spring.services;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.entity.Equipe;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.reposotiries.ContratRepository;
import tn.esprit.spring.reposotiries.DepartmentRepoitory;
import tn.esprit.spring.reposotiries.EquipeReposirory;
import tn.esprit.spring.reposotiries.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Service //cree une instance(bean) de cette classe
public class IEtudientServiceIMP implements etudiantService {

    //@Autowired
    EtudiantRepository etudiantrepository;
    //@Autowired
    DepartmentRepoitory departementeepository;
    //@Autowired
    ContratRepository contratrepository;
    //@Autowired
    EquipeReposirory equiperepository ;


    @Override
    public Etudiant addStudent(Etudiant e) {
        return etudiantrepository.save(e);
    }

    @Override
    //si on a objet student exist yapdati si yajouti
    public Etudiant updateStudent(Etudiant e) {
        return etudiantrepository.save(e);
    }

    @Override
    public Etudiant getById(Integer idEtudiant) {
        return etudiantrepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllStudent() {
        return etudiantrepository.findAll() ;
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        etudiantrepository.deleteById(idEtudiant);

    }

    @Override
    public void addAndAssignEtudiant(Integer etudiantId, Integer depId) {

        //recuperation de id
        Etudiant etudiant = etudiantrepository.findById(etudiantId).orElse(null);
        Departement department = departementeepository.findById(depId).orElse(null);
        //condition si exist
        if (etudiant != null && department != null)
        {
            etudiant.setDepartement(department);
            //save
            etudiantrepository.save(etudiant);
        }
    }
    @Transactional
    @Override
    public Etudiant AssignEtudiantToEquipeAndContrat(Etudiant e, Integer idContrat, Integer idEquipe) {

        Contrat contrat = contratrepository.findById(idContrat).orElse(null);
        Equipe equipe = equiperepository.findById(idEquipe).orElse(null);
        //ili fih mapped by mmouch houwa ygeri entity lokhra
        //
        if (contrat != null && equipe != null ){
            Etudiant etudiant = etudiantrepository.save(e); // rajaat etud ili zedtou management entity

            contrat.setEtudiant(e);
            // contratrepository.save(contrat);//@transaction titnaha w lezem tkoun entity management contrat w equipe yaani aandou ref f DB

            equipe.getEtudiants().add(etudiant);//getlist students and affecte him to setList // weli zedtou etud houwa bidou nzidou f equipe
            // equiperepository.save(equipe);//@transaction tweli titnaha star hedha

            //methode cas particulier
            //si etudiant ygeri equipe f cas many to many w liste non initaliser
             /*if(etudiant.getEquipes()!=null){
            etudiant.getListeEquipes().add(equipe);
            }else
            List<Equipe> equipe1 = new ArrayList<Equipe>();
            equipe1.add(equipe);
            etudiant.setEquipe(equipe);
            }
*/
            //return etudiantrepository.save(e);//dzed khtyr m loul save etudiant
            return  etudiant ;
        }

        return null ;





    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {

        return etudiantrepository.findEtudiantsByDepartementIdDepartement(idDepartement);


}}
