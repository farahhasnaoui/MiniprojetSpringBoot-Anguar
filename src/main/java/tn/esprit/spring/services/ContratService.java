package tn.esprit.spring.services;

import tn.esprit.spring.entity.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratService {
    public Contrat addContract(Contrat c);
    public Contrat updateContract(Contrat c);
    public Contrat retrieveContract(Integer idC);
    public List<Contrat> getAllContracts();
    public void removeContract(Integer idC);
    public Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    public void retrieveAndUpdateStatusContrat();
}
