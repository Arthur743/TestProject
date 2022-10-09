package myproject.service.abstracts;

import myproject.models.Role;
import java.util.List;

public interface RoleService {

    List<Role> getRoles();

    Role getSpecificRoles(int id);

    void setRole(Role role);

    Role getRole(String name);

}
