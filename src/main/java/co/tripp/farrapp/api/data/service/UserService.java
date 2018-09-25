package co.tripp.farrapp.api.data.service;


import co.tripp.farrapp.api.data.model.User;

import java.util.List;

/**
 * @author Tripp
 */
public interface UserService
{
    List<User> getUsers();

    User getUserById( long id );

    User getUserByEmail (String email);

    void createUser( User user );
}