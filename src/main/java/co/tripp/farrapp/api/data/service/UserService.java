package co.tripp.farrapp.api.data.service;
import co.tripp.farrapp.api.data.model.Party;
import co.tripp.farrapp.api.data.model.User;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Tripp
 */
public interface UserService
{
    void addNewUser (User user);

    void modifyUserInfo (String emailUser, String newName, String newLastName, int newId, String newEmail);

    void modifyUserPassword (String emailUser, String newPassword);

    ConcurrentHashMap<String, User> getUsers();

    User getUserByEmail(String email);

    void addUserParty(String email, Party party);

    void removeUserParty(String email, int partyId);

}