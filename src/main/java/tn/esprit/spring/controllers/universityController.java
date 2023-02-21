package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Universite;
import tn.esprit.spring.services.UniversiteService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/university")
public class universityController {
    List<Universite> UNI = new ArrayList<Universite>();

    @Autowired
    UniversiteService universiteService;

    @PostMapping("/addUni")
    public Universite addUniversity(@RequestBody Universite u) {
        return universiteService.addUniversite(u);

    }

    @PutMapping("/editUni")
    public Universite updateUniversity(@RequestBody Universite u) {
        return universiteService.updateUniversity(u);

    }

    @GetMapping("/retrieveUni/{idUni}")
    public Universite getEqById(@PathVariable Integer idUni) {
        return universiteService.retrieveUniversity(idUni);

    }

    @GetMapping("/listUni")
    public List<Universite> listeUniversity() {
        return universiteService.getAllUniversities();

    }

    @DeleteMapping("/deleteUni/{idUni}")
    public void deleteUniversity(@PathVariable Integer idUni) {
        universiteService.removeUniversity(idUni);
    }

    @PutMapping("/asseignnivToDepartement/{Iduniversity}/{depId}")
    public void AssignUniversityToDepartement(@PathVariable Integer Iduniversity, @PathVariable Integer depId) {
        universiteService.assignUniversiteToDepartement(Iduniversity, depId);

    }


}