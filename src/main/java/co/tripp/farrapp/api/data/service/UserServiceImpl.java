package co.tripp.farrapp.api.data.service;

import co.tripp.farrapp.api.data.model.Party;
import co.tripp.farrapp.api.data.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {
    private ConcurrentHashMap<String, User> users;

    public UserServiceImpl() {
        users = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void populateData() {
        List<Party> myPartiesTest = new ArrayList<>();
        Party myParty = new Party("Candy FLip", "Armando Halloween",
                "Fiesta realizada el 31 de diciembre para el dia de las brujas",
                "31/10/2018",
                "21:00",
                "Ac. 85 #15-30",
                "Armando Records",
                0,
                "Cover gratis toda la noche para los espiritus mas fiesteros",
                null);
        myParty.setId(4);
        myPartiesTest.add(myParty);
        users.put("juan.ramirez-me@mail.escuelaing.edu.co", new User(
                "Juan David",
                "Ramirez Mendoza",
                "juan.ramirez-me@mail.escuelaing.edu.co",
                "qwerty1",
                1019139950,
                "User",
                myPartiesTest
        ));

        users.put("kevin.mendieta@mail.escuelaing.edu.co", new User(
                "Kevin Jeffrey",
                "Mendieta Perez",
                "kevin.mendieta@mail.escuelaing.edu.co",
                "qwerty2",
                1020456768,
                "Admin", new ArrayList<>()
        ));
        users.put("nicolas.osorio@mail.escuelaing.edu.co", new User(
                "Nicolas",
                "Osorio Arias",
                "nicolas.osorio@mail.escuelaing.edu.co",
                "qwerty3",
                234542311,
                "User", new ArrayList<>()
        ));
    }

    @Override
    public void addNewUser(User user) {
        users.put(user.getEmail(), user);
    }

    @Override
    public void modifyUserInfo(String emailUser, String newName, String newLastName, int newId, String newEmail) {
        String password = users.get(emailUser).getPassword();
        users.remove(emailUser);
        users.put(newEmail, new User(newName, newLastName, newEmail, password, newId));
    }

    @Override
    public void modifyUserPassword(String emailUser, String newPassword) {
        users.get(emailUser).setPassword(newPassword);
    }


    @Override
    public ConcurrentHashMap<String, User> getUsers() {
        return users;
    }


    @Override
    public User getUserByEmail(String email) {
        return users.get(email);
    }

    @Override
    public void addUserParty(String email, Party party) {
        users.get(email).addParty(party);
    }

    @Override
    public void removeUserParty(String email, int partyId) {
        users.get(email).removeParty(partyId);
    }

    @Override
    public  void  bookUserToParty(String email, Party party){party.addAssistant(users.get(email));}


}
