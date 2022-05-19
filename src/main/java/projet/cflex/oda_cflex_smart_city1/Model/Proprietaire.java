package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "proprietaire")
@SQLDelete(sql = "UPDATE proprietaire SET statut = true WHERE id=?")
@FilterDef(name = "deletedProprietaireFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedProprietaireFilter", condition = "statut = :isDeleted")
public class Proprietaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "statut")
    private Boolean statut;

    @Column(name = "permis")
    private String permis;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "genre", nullable = false, length = 1)
    private String genre;

    @Column(name = "lieu_naissance")
    private String lieuNaissance;

    @Column(name = "lieu_residence", nullable = false)
    private String lieuResidence;

    @Column(name = "piece_identite", nullable = false)
    private String pieceIdentite;

}