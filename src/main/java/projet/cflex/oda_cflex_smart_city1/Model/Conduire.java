package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;

import javax.persistence.*;
import java.lang.annotation.Documented;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "conduire")
public class Conduire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicule")
    private Vehicule idVehicule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chauffeur")
    private Chauffeur idChauffeur;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

}