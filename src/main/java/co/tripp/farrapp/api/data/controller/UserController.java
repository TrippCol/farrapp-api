package co.tripp.farrapp.api.data.controller;

import co.tripp.farrapp.api.data.model.User;
import co.tripp.farrapp.api.data.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletException;
import java.util.Date;

/**
 * @author Tripp
 */
@RestController
@RequestMapping( "users" )
public class UserController
{

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login( @RequestBody User login )
            throws ServletException
    {

        String jwtToken = "";

        if ( login.getEmail() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in email and password" );
        }

        String email = login.getEmail();
        String password = login.getPassword();;
        User user = userService.getUserById( login.getId() );

        if ( user == null )
        {
            throw new ServletException( "User username not found." );
        }

        String pwd = user.getPassword();


        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your name and password." );
        }


        jwtToken = Jwts.builder().setSubject( email ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
                SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( method=RequestMethod.POST )
    public ResponseEntity<?> addNewUser(@RequestBody User user){
        userService.addNewUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value="/user-info/{idUser}", method=RequestMethod.PUT )
    public ResponseEntity<?> modifyUserInfo(@PathVariable(name = "idUser") int idUser, @RequestBody User user){
        userService.modifyUserInfo
                (
                idUser,
                user.getName(),
                user.getLastName(),
                user.getId(),
                user.getEmail()
                );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value="/user-password/{idUser}", method=RequestMethod.PUT )
    public ResponseEntity<?> modifyUserPassword(@PathVariable(name = "idUser") int idUser, @RequestBody User user){
        userService.modifyUserPassword
                (
                        idUser,
                        user.getPassword()
                );
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( method=RequestMethod.GET )
    public ResponseEntity<?> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value="/{idUser}", method=RequestMethod.GET )
    public ResponseEntity<?> getUser(@PathVariable(name = "idUser") int idUser){
        return new ResponseEntity<>(userService.getUserById(idUser), HttpStatus.ACCEPTED);
    }


    public class Token
    {

        String access_token;


        public Token( String access_token )
        {
            this.access_token = access_token;
        }


        public String getAccessToken()
        {
            return access_token;
        }

        public void setAccessToken( String access_token )
        {
            this.access_token = access_token;
        }
    }

}