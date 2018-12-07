package co.tripp.farrapp.api.data.services.user.impl;

import co.tripp.farrapp.api.data.model.Party;
import co.tripp.farrapp.api.data.model.User;
import co.tripp.farrapp.api.data.repositories.UserRepository;
import co.tripp.farrapp.api.data.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MongoUserService implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void modifyUserInfo(String emailUser, String newName, String newLastName, int newId, String newEmail) {
        User user = userRepository.findByEmail(emailUser);
        userRepository.deleteByEmail(emailUser);
        user.setName(newName);
        user.setLastName(newLastName);
        user.setId(newId);
        user.setEmail(newEmail);
        userRepository.save(user);
    }

    @Override
    public void modifyUserPassword(String emailUser, String newPassword) {
        User user = userRepository.findByEmail(emailUser);
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    @Override
    public ConcurrentHashMap<String, User> getUsers() {
        ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
        List<User> mongoUsers = userRepository.findAll();
        for (User u : mongoUsers) {
            users.put(u.getEmail(), u);
        }
        return users;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void addUserParty(String email, Party party) {
        User user = userRepository.findByEmail(email);
        user.addParty(party);
        userRepository.save(user);
    }

    @Override
    public void removeUserParty(String email, int partyId) {
        User user = userRepository.findByEmail(email);
        user.removeParty(partyId);
        userRepository.save(user);
    }
}
