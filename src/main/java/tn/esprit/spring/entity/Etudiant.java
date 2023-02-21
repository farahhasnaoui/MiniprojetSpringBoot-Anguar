
package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name ="Etudiant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Integer idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;

    @Enumerated(EnumType.STRING)
    Option opt ;
    @ManyToMany
    Set<Equipe> equipes ;
    @OneToMany(mappedBy = "etudiant")
    Set<Contrat> contrats ;

    @ManyToOne
    private Departement departement ;


}
