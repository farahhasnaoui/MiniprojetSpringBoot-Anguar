package tn.esprit.spring.Models;

import lombok.Data;
import tn.esprit.spring.entity.Niveau;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Data
public class EquipeModel {
    private String nomEquipe;
private  String niveau;



}
