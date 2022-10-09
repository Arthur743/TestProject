package myproject.service.imp;

import myproject.dao.abstracts.UserDao;
import myproject.models.User;
import myproject.service.abstracts.RoleService;
import myproject.service.abstracts.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.updateUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void setUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.setUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails getSpecificUsername(String username) throws UsernameNotFoundException {
        return userDao.getSpecificUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public User getSpecificUser(String username) throws UsernameNotFoundException {
        return userDao.getSpecificUsernameOfUser(username);
    }
}
