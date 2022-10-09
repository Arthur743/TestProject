package myproject.service.abstracts;

import myproject.models.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    void updateUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    void setUser(User user);

    UserDetails getSpecificUsername(String s);

    User getSpecificUser(String username);

}
