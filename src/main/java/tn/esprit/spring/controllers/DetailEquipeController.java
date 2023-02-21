package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Models.DetailEquipeModel;
import tn.esprit.spring.Models.EquipeModel;
import tn.esprit.spring.entity.DetailEquipe;
import tn.esprit.spring.entity.Equipe;
import tn.esprit.spring.services.DetailEquipeService;
import tn.esprit.spring.services.EquipeService;
import tn.esprit.spring.services.IDetailEquipe;
import tn.esprit.spring.services.IEquipeServiceIMP;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/detailequipe")
public class DetailEquipeController {

    @Autowired
    IDetailEquipe iDetailEquipe;

@Autowired
    IEquipeServiceIMP iEquipeServiceIMP;

@Autowired
DetailEquipeService detailEquipeService;
    @PostMapping("/addDE")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe det){
        return iDetailEquipe.addDetailEquipe(det);
    }
    @PostMapping("/adddetailEquipe")
    void addEquipe(@RequestBody DetailEquipeModel model){
        DetailEquipe detailequipe =new DetailEquipe();
        detailequipe.setSalle(model.getSalle());
        detailequipe.setThematique(model.getThematique());
        detailequipe.setEquipe(this.iEquipeServiceIMP.getById(model.getIdEquipe()));
        this.iDetailEquipe.addDetailEquipe(detailequipe);

    }
    @GetMapping("/listeDEquipe")
     List<DetailEquipe> listeDetailEquipee(){
        return this.iDetailEquipe.retrieveAllDetailEquipe();

    }
    @PutMapping("/editDEq/{idDetailEquipe}")
    public DetailEquipe updateEquipe(@RequestBody DetailEquipeModel det,@PathVariable  Integer idDetailEquipe){
        DetailEquipe detailEquipe=new DetailEquipe();

        detailEquipe.setSalle(det.getSalle());
        detailEquipe.setThematique(det.getThematique());
        detailEquipe.setEquipe(this.iEquipeServiceIMP.getById(det.getIdEquipe()));
       return this.iDetailEquipe.updateDetailEquipe(detailEquipe,idDetailEquipe);

    }
    @GetMapping("/retrieveDEq/{idDetailEquipe}")
    public DetailEquipe getEqById(@PathVariable Integer idDetailEquipe){
        return iDetailEquipe.retrieveDetailEquipe(idDetailEquipe);
    }

    @GetMapping("/listeDEq")
    public List<DetailEquipe> listeDetailEquipe(){
        return iDetailEquipe.retrieveAllDetailEquipe();

    }


    @DeleteMapping("/deleteE/{idDetailEquipe}")
    public void deleteEquipe(@PathVariable Integer idDetailEquipe){
        iDetailEquipe.removeDetailEquipe(idDetailEquipe);
    }

}
