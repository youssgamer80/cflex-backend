package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Role;
import projet.cflex.oda_cflex_smart_city1.Repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    public RoleRepository roleRepository;
    private Boolean statut = true;
    public Role role;


    public List<Role> getAllRoles() {
        
        List<Role> roles = new ArrayList<>();

        roleRepository.findByStatutJPQL(statut).forEach(roles::add);

        return roles;
    }
    
    public Role addRole(Role role) {

        return roleRepository.save(role);
    }

    public Role getRole(int id) {

        return this.roleRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Role not found with id :" + id));
    }

    public Role updateRole(Integer id, Role role) {

        Role existingRole = this.roleRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Usager not found with id :" + id));
        if(role.getRole()!=null){
             existingRole.setRole(role.getRole());
        }

       if(role.getStatut()!=null){
        existingRole.setStatut(role.getStatut());
   }

		return roleRepository.save(existingRole);
    }

    public Role deleteRole(Integer id){
        Role real = this.roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role" + id + "nexiste pas"));
        real.setStatut(false);
        return roleRepository.save(real);
    }
}
