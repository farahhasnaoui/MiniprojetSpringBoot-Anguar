package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.services.ContratService;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contract")
public class contractController {

    List<Contrat> Con = new ArrayList<Contrat>();

    @Autowired
    ContratService contratService ;

    @PostMapping("/addCon")
    public Contrat addContract(@RequestBody Contrat c){
        return contratService.addContract(c);

    }
    @PutMapping("/editCon")
    public Contrat updateContract(@RequestBody Contrat c){
        return contratService.updateContract(c);

    }
    @GetMapping("/retrieveCon/{idCon}")
    public Contrat getContractById(@PathVariable Integer idCon){
        return contratService.retrieveContract(idCon);

    }
    @GetMapping("/listeCon")
    public List<Contrat> listecontract(){
        return contratService.getAllContracts();

    }
    @DeleteMapping("/deleteE/{idCon}")
    public void deleteContract(@PathVariable Integer idCon){
        contratService.removeContract(idCon);
    }

    @PutMapping("/affConET/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce, @PathParam("nomE") String nomE, @PathParam("prenomE") String PrenomE){
        return contratService.affectContratToEtudiant(ce,nomE,PrenomE);
    }




    @GetMapping("/chiffreaffaire/{startDate}/{endDate}")
    public float getchiffredaffaire(@PathParam("startDate")Date startDate ,@PathParam("endDate" )Date endDate){
        return contratService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }

}
