package myproject.dao.abstracts;

import myproject.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    void updateUser(User user);

    User getUser(int id);

    void deleteUser(int id);

    void setUser(User user);

    User getSpecificUsername(String username);

    User getSpecificUsernameOfUser(String username);
}
