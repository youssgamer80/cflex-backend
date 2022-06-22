package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "utilisateur")
@SQLDelete(sql = "UPDATE utilisateur SET statut = false WHERE id=?")
@FilterDef(name = "deletedUtilisateurFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedUtilisateurFilter", condition = "statut = :isDeleted")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom_utilisateur", nullable = false)
    private String nomUtilisateur;

    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_role_fk", nullable = false)
    private Role Role;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

}