package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;

@Entity
@Table(name = "`role-permission`")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_role_fk", nullable = false)
    private Role idRoleFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_permission_fk", nullable = false)
    private Permission idPermissionFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getIdRoleFk() {
        return idRoleFk;
    }

    public void setIdRoleFk(Role idRoleFk) {
        this.idRoleFk = idRoleFk;
    }

    public Permission getIdPermissionFk() {
        return idPermissionFk;
    }

    public void setIdPermissionFk(Permission idPermissionFk) {
        this.idPermissionFk = idPermissionFk;
    }

}