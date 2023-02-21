package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Departement;
import tn.esprit.spring.services.departmentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
public class departmentController {
    List<Departement> departements = new ArrayList<Departement>();

    @Autowired
    departmentService departementService;

    @PostMapping("/addDept")
    public Departement addDepartement(@RequestBody Departement d)
    {
        return departementService.addDepartement(d);
    }

    @PutMapping("/editDep")
    public Departement updateDepartement(@RequestBody Departement d) {
        return departementService.updateDepartement(d);

    }

    @GetMapping("/retrieveDep/{idDep}")
    public Departement retrieveDepartement(@PathVariable Integer idDep) {
        return departementService.retrieveDepartement(idDep);

    }

    @GetMapping("/listeDep")
    public List<Departement> listeDepartement() {
        return departementService.retrieveAllDepartement();
    }
    @PutMapping("/assign/{idUniversite}/{idDepartement}")
    public void addAndAssignDepartement(@PathVariable Integer idUniversite,@PathVariable Integer idDepartement) {
        departementService.assignUniversiteToDepartement(idUniversite,idDepartement);
    }
    @GetMapping("/retriveDepByUniv/{idUniversity}")
    public List<Departement> retrieveDepartementByUniversity(@PathVariable Integer idUniversity){
        return departementService.retrieveDepartementsByUniversite(idUniversity);
    }
}
