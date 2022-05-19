package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "mode_deplacement")
public class ModeDeplacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "mode_deplacement")
    private String modeDeplacement;

    @Column(name = "statut")
    private Boolean statut;

}