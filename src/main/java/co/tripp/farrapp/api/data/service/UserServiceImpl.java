package co.tripp.farrapp.api.data.service;

import co.tripp.farrapp.api.data.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private List<User> users = new ArrayList();
    @Override
    public List<User> getUsers() {
        return users;
    }

    @PostConstruct
    private void populateData(){
        users.add(new User("Juan David", "Ramirez Mendoza", "juandavidramirezmendoza@hotmail.com", "qwerty", 1019138849));
    }

    @Override
    public User getUserById(long id) {
        User userFound = null;
        for (User u: users){
            if(u.getId() == id){
                userFound = u;
            }
        }
        return userFound;

    }

    @Override
    public User getUserByEmail(String email) {
        User userFound = null;
        for (User u: users){
            if(u.getEmail().equals(email)){
                userFound = u;
            }
        }
        return userFound;
    }

    @Override
    public void createUser(User user) {
        users.add(user);
    }
}
