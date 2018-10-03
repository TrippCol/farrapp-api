package co.tripp.farrapp.api.data.service;

import co.tripp.farrapp.api.data.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {
    private ConcurrentHashMap<Integer, User> users;

    public UserServiceImpl(){
        users = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void populateData(){
        users.put(1019139950, new User(
                "Juan David",
                "Ramirez Mendoza",
                "juan.ramirez-me@mail.escuelaing.edu.co",
                "qwerty1",
                1019139950
        ));

        users.put(1020456768, new User(
                "Kevin Jeffrey",
                "Mendieta Perez",
                "kevin.mendieta@mail.escuelaing.edu.co",
                "qwerty2",
                1020456768
        ));
        users.put(234542311, new User(
            "Nicolas",
            "Osorio Arias",
            "nicolas.osorio@mail.escuelaing.edu.co",
            "qwerty3",
            234542311
            ));
    }
    @Override
    public void addNewUser (User user){
        users.put(user.getId(), user);
    }

    @Override
    public void modifyUserInfo (int idUser, String newName, String newLastName, int newId, String newEmail){
        String password = users.get(idUser).getPassword();
        users.remove(idUser);
        users.put(newId, new User(newName, newLastName, newEmail, password, newId));
    }

    @Override
    public void modifyUserPassword (int idUser, String newPassword){
        users.get(idUser).setPassword(newPassword);
    }


    @Override
    public ConcurrentHashMap<Integer, User> getUsers() {
        return users;
    }


    @Override
    public User getUserById(int id) {
        return users.get(id);
    }
}
