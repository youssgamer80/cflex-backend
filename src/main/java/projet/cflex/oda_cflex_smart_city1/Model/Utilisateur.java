package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "utilisateur")
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
    private Role idRoleFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

}