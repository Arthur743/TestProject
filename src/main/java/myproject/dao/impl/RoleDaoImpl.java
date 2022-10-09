package myproject.dao.impl;

import myproject.dao.abstracts.RoleDao;
import myproject.models.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getRoles() {
        return entityManager.createQuery("select role from Role role", Role.class).getResultList();
    }

    @Override
    public Role getSpecificRoles(int id) {
        TypedQuery<Role> query = entityManager.createQuery("select role from Role role where role.id =:id", Role.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }

    @Override
    public void setRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role getRole(String name) {
        return entityManager
                .createQuery("select role from Role role where role.name = :name", Role.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
