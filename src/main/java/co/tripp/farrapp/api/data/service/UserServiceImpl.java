package co.tripp.farrapp.api.data.service;

import co.tripp.farrapp.api.data.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {
    private ConcurrentHashMap<String, User> users;

    public UserServiceImpl(){
        users = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void populateData(){
        users.put("juan.ramirez-me@mail.escuelaing.edu.co", new User(
                "Juan David",
                "Ramirez Mendoza",
                "juan.ramirez-me@mail.escuelaing.edu.co",
                "qwerty1",
                1019139950
        ));

        users.put("kevin.mendieta@mail.escuelaing.edu.co", new User(
                "Kevin Jeffrey",
                "Mendieta Perez",
                "kevin.mendieta@mail.escuelaing.edu.co",
                "qwerty2",
                1020456768
        ));
        users.put("nicolas.osorio@mail.escuelaing.edu.co", new User(
            "Nicolas",
            "Osorio Arias",
            "nicolas.osorio@mail.escuelaing.edu.co",
            "qwerty3",
            234542311
            ));
    }
    @Override
    public void addNewUser (User user){
        users.put(user.getEmail(), user);
    }

    @Override
    public void modifyUserInfo (String emailUser, String newName, String newLastName, int newId, String newEmail){
        String password = users.get(emailUser).getPassword();
        users.remove(emailUser);
        users.put(newEmail, new User(newName, newLastName, newEmail, password, newId));
    }

    @Override
    public void modifyUserPassword (String emailUser, String newPassword){
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
}
