package co.tripp.farrapp.api.data.service;

import co.tripp.farrapp.api.data.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {
    private ConcurrentHashMap<Integer, User> users;

    public UserServiceImpl(){
        users = new ConcurrentHashMap<>();
    }

    @PostConstruct
    private void populateData(){
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
    public void modifyUserInfo (User user, String name, String lastName, int id, String newEmail){
        for(int i = 0; i <= users.size(); i++){
            if(users.get(i).getEmail().equals(user.getEmail())){
                users.get(i).setEmail(newEmail);
                users.get(i).setName(name);
                users.get(i).setLastName(lastName);
                users.get(i).setId(id);
            }
        }
    }

    @Override
    public void modifyUserPassword (String newPassword, User user){
        System.out.println(user.getEmail());
        for(int i = 0; i <= users.size(); i++){
            if(users.get(i).getEmail().equals(user.getEmail())){
                users.get(i).setPassword(newPassword);
            }
        }
    }


    @Override
    public ConcurrentHashMap<Integer, User> getUsers() {
        return users;
    }

    @Override
    public User getUserByEmail(String email) {
        /*User userFound = null;
        for (User u: users){
            if(u.getEmail().equals(email)){
                userFound = u;
            }
        }
        return userFound;*/
        return null;
    }

    @Override
    public User getUserById(long id) {
        /*User userFound = null;
        for (User u: users){
            if(u.getId() == id){
                userFound = u;
            }
        }
        return userFound;*/
        return null;
    }
}
