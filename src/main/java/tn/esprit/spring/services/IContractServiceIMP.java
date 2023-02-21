package tn.esprit.spring.services;

import org.aspectj.bridge.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Contrat;
import tn.esprit.spring.entity.Etudiant;
import tn.esprit.spring.reposotiries.ContratRepository;
import tn.esprit.spring.reposotiries.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class IContractServiceIMP  implements  ContratService{

    @Autowired
    ContratRepository contratrepository;
    @Autowired
    EtudiantRepository etudiantrepository;


    @Override
    public Contrat addContract(Contrat c) {
        return contratrepository.save(c);
    }

    @Override
    public Contrat updateContract(Contrat c) {
        return contratrepository.save(c);
    }

    @Override
    public Contrat retrieveContract(Integer idC) {
        return contratrepository.findById(idC).orElse(null);
    }

    @Override
    public List<Contrat> getAllContracts() {
        return contratrepository.findAll();
    }

    @Override
    public void removeContract(Integer idC) {
        contratrepository.deleteById(idC);

    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {

        List<Etudiant> etudiants = etudiantrepository.findAll();
        List<Etudiant> contratslist;
        Etudiant etudiant = null;
        for (Etudiant Etudiant1 : etudiants) {
            if (Etudiant1.getNomE().equals(nomE) && Etudiant1.getPrenomE().equals(prenomE)) {
                //ceEtud=i.getIdEtudiant();
                etudiant = Etudiant1;
            }
        }
        int nbrCotratActifs = 0;
        if (etudiant != null) {
            for (Contrat c : etudiant.getContrats()) {
                if (!c.isArchive()) {
                    nbrCotratActifs++;
                }
            }
            if (nbrCotratActifs < 5) {
                ce.setEtudiant(etudiant);
                return contratrepository.save(ce);
            }
        }



            /*
            Etudiant etud = etudiantrepository.findByNomEAndPrenomE(nomE,prenomE);
            int nbrContratsActifs = contratrepository.countByArchiveIsFalseAndEtudiantNomEAndEtudiantPrenomE();
            if (nbrContratsActifs < 5){
                ce.setEtudiant(etud);
                return contratrepository.save(ce);
            }*/
        return contratrepository.save(ce);


    }
    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = contratrepository.findAll();
        // SimpleDateFormat df=new SimpleDateFormat("DD/MM/YYYY");
        //  String SD= startDate.toString();
        // String ED= endDate.toString();
        // Date dateA=df.parse(String SD);
        // Date dateB=df.parse(String ED);
        long diff = endDate.getTime() - startDate.getTime();
        double chiffreAffaire = 0;
        //double resultat =0 ;
        for (Contrat ct : contrats) {
            if (ct.isArchive() == false) {
                if ((ct.getDateDebutContrat().before(startDate)) && (ct.getDateFinContrat().after(endDate))) {

                    double diffMois = diff / (1000 * 60 * 60 * 24 * 30);
                    double resultat =0 ;
                    switch (ct.getSpecialite()) {
                        case IA:
                            chiffreAffaire =+ diffMois * 300;
                            break;
                        case RESEAUX:
                            chiffreAffaire =+ diffMois * 350;
                            break;
                        case CLOUD:
                            chiffreAffaire =+ diffMois * 400;
                            break;
                        case SECURITE:
                            chiffreAffaire =+ diffMois * 450;
                            break;
                    }
                    return (float) chiffreAffaire;
                }

            }

        }
        return (float) chiffreAffaire;
    }

    @Override
    public void retrieveAndUpdateStatusContrat() {

    }
    /*@Transactional
    public void archiveContrats (){
        contratrepository.findByArchiveIsFalseAndDateFinContract(new Date())
                .stream().forEach(Contract -> Contract.setArchive(true));
        //kont najim nhot repo.save ama aadi @Transact commit mte3na
    }
    //spring scudle teb3a spring framework lezem nactivi schdule
    @Scheduled(fixedRate = 60000 )
    @Override
    public void retrieveAndUpdateStatusContrat() {
      /*  List<Contrat> contrats= contratrepository.findByArchiveIsFalse();
        this.archiveContrats();
        Object HelperClass = null;
        MessageUtil log = null;
        contrats.stream().
                filter(Contract ->
                        HelperClass.DiffTwoDate(new Date(),Contrat.getDateFinContrat())<16)
                .forEach(Contract ->
                        log.info("le contrat de l etudiant : "+ Contract.getEtudiant().getNomE()));

    }/*

}

       */

    }