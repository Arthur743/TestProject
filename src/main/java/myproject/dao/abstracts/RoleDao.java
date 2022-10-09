package myproject.dao.abstracts;

import myproject.models.Role;

import java.util.List;

public interface RoleDao {

    public List<Role> getRoles();

    Role getSpecificRoles(int id);

    public void setRole(Role role);

    Role getRole(String name);
}
