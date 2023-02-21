package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.DataInput;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table( name ="Contrat")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private int idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat ;
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat ;

    private boolean archive ;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    Etudiant etudiant;

    private Integer montantContrat ;
    @Enumerated(EnumType.STRING)
    Specialite specialite;


}
