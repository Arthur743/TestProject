package myproject.service.imp;

import myproject.models.Role;
import myproject.service.abstracts.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import myproject.dao.abstracts.RoleDao;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    @Transactional(readOnly = true)
    public Role getSpecificRoles(int id) {
        return roleDao.getSpecificRoles(id);
    }

    @Override
    @Transactional
    public void setRole(Role role) {
        roleDao.setRole(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRole(String name) {
        return roleDao.getRole(name);
    }


}
