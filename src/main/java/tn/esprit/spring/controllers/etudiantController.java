package tn.esprit.spring.controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.services.etudiantService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/student")
public class etudiantController {


    //@Autowired//inject a bean that implement the etudiant service // field injection
    private etudiantService ietudiantService ;


    @PostMapping("/addE")
    public Etudiant addEtudiant(@RequestBody Etudiant e){
       return ietudiantService.addStudent(e);

    }
    //depart id pathvariable
    //recuperation des objet
    //affecte heja fi heja  //traitement
    //save
    @PutMapping("/editE")
    public Etudiant updateEtudiant(@RequestBody Etudiant e){
        return ietudiantService.updateStudent(e);

    }
    @GetMapping("/getById/{idE}")
    public Etudiant getEtudiantById(@PathVariable Integer idE){
           return ietudiantService.getById(idE);

    }
    @GetMapping("/listE")
    public List<Etudiant> listeEtudiant(){
        return ietudiantService.getAllStudent();

    }
    @DeleteMapping("/deleteE/{idEtudiant}")
    public void deleteEtudiant(@PathVariable Integer idEtudiant){
        ietudiantService.removeEtudiant(idEtudiant);
    }

    @PostMapping("/addAssignE/{etudiantId}/{depId}")
    public void addAndAssign(@PathVariable Integer etudiantId ,@PathVariable Integer depId){
         ietudiantService.addAndAssignEtudiant(etudiantId,depId);
        // return new ResponseEntity<>("Added", HttpStatus.OK);
    }
    @PostMapping("/asetoec/{idContrat}/{idEquipe}")
    public ResponseEntity AssignEtudiantToEquipeAndConstrat(@RequestBody  Etudiant e , @PathVariable Integer idContrat , @PathVariable Integer idEquipe){
        ietudiantService.AssignEtudiantToEquipeAndContrat( e,idContrat,idEquipe);
        return new ResponseEntity<>("Added", HttpStatus.OK);
    }

    @GetMapping("/etudByDep/{idDepartment}")
    public List<Etudiant> findByDep(@PathVariable int idDepartment){
        return ietudiantService.getEtudiantsByDepartement(idDepartment);
    }
}
