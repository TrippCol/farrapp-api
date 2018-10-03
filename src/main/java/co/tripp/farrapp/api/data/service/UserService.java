package co.tripp.farrapp.api.data.service;
import co.tripp.farrapp.api.data.model.User;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Tripp
 */
public interface UserService
{
    void addNewUser (User user);

    void modifyUserInfo (int idUser, String newName, String newLastName, int newId, String newEmail);

    void modifyUserPassword (int idUser, String newPassword);

    ConcurrentHashMap<Integer, User> getUsers();


    User getUserById (int id);
}