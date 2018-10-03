package co.tripp.farrapp.api.data.service;
import co.tripp.farrapp.api.data.model.User;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Tripp
 */
public interface UserService
{
    void addNewUser (User user);

    void modifyUserInfo (User user, String name, String lastName, int id, String newEmail);

    void modifyUserPassword (String newPassword, User user);

    ConcurrentHashMap<Integer, User> getUsers();

    User getUserByEmail (String email);

    User getUserById (long id);
}