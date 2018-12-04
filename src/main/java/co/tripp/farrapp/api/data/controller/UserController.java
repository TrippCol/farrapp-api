package co.tripp.farrapp.api.data.controller;

import co.tripp.farrapp.api.data.model.Party;
import co.tripp.farrapp.api.data.model.User;
import co.tripp.farrapp.api.data.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;

/**
 * @author Tripp
 */
@RestController
@RequestMapping( "users" )
public class UserController
{

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "https://farrapp-frontend.herokuapp.com")
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
        String password = login.getPassword();
        User user = userService.getUserByEmail( email );

        if ( user == null )
        {
            throw new ServletException( "User email not found." );
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

    @CrossOrigin(origins = "https://farrapp-frontend.herokuapp.com")
    @RequestMapping( method=RequestMethod.POST )
    public ResponseEntity<?> addNewUser(@RequestBody User user){
        userService.addNewUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "https://farrapp-frontend.herokuapp.com")
    @RequestMapping( value="/user-info/{emailUser}", method=RequestMethod.PUT )
    public ResponseEntity<?> modifyUserInfo(@PathVariable(name = "emailUser") String emailUser, @RequestBody User user){
        try {
            String decodedEmailUser = URLDecoder.decode(emailUser, "UTF-8");
            userService.modifyUserInfo
                    (
                            decodedEmailUser,
                            user.getName(),
                            user.getLastName(),
                            user.getId(),
                            user.getEmail()
                    );
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;

    }

    @CrossOrigin(origins = "https://farrapp-frontend.herokuapp.com")
    @RequestMapping( value="/user-password/{emailUser}", method=RequestMethod.PUT )
    public ResponseEntity<?> modifyUserPassword(@PathVariable(name = "emailUser") String emailUser, @RequestBody User user){

        try {
            String decodedEmailUser = URLDecoder.decode(emailUser, "UTF-8");
            userService.modifyUserPassword
                    (
                            decodedEmailUser,
                            user.getPassword()
                    );
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;

    }

    @CrossOrigin(origins = "https://farrapp-frontend.herokuapp.com")
    @RequestMapping( method=RequestMethod.GET )
    public ResponseEntity<?> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "https://farrapp-frontend.herokuapp.com")
    @RequestMapping( value="/{emailUser}", method=RequestMethod.GET )
    public ResponseEntity<?> getUser(@PathVariable(name = "emailUser") String emailUser){
        try
        {
            String decodedEmailUser = URLDecoder.decode(emailUser, "UTF-8");
            return new ResponseEntity<>(userService.getUserByEmail(decodedEmailUser), HttpStatus.ACCEPTED);
        }catch(Exception e){
            System.out.println(e);
        }
            return null;

    }

    @CrossOrigin(origins = "https://farrapp-frontend.herokuapp.com")
    @RequestMapping( value="/{emailUser}/parties", method=RequestMethod.GET )
    public ResponseEntity<?> getUserParties(@PathVariable(name = "emailUser") String emailUser){
        try
        {
            String decodedEmailUser = URLDecoder.decode(emailUser, "UTF-8");
            return new ResponseEntity<>(userService.getUserByEmail(decodedEmailUser).getMyParties(), HttpStatus.ACCEPTED);
        }catch(Exception e){
            System.out.println(e);
        }
        return null;

    }

    @CrossOrigin(origins = "https://farrapp-frontend.herokuapp.com")
    @RequestMapping( value="/{emailUser}/parties/add", method=RequestMethod.PUT )
    public ResponseEntity<?> addUserParty(@PathVariable(name = "emailUser") String emailUser, @RequestBody Party party){

        try {
            String decodedEmailUser = URLDecoder.decode(emailUser, "UTF-8");
            userService.addUserParty
                    (
                            decodedEmailUser,
                            party
                    );
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;

    }



    @CrossOrigin(origins = "https://farrapp-frontend.herokuapp.com")
    @RequestMapping( value="/{emailUser}/parties/remove", method=RequestMethod.PUT )
    public ResponseEntity<?> removeUserParty(@PathVariable(name = "emailUser") String emailUser, @RequestBody Map<String, Integer> partyId){

        try {
            String decodedEmailUser = URLDecoder.decode(emailUser, "UTF-8");
            userService.removeUserParty
                    (
                            decodedEmailUser,
                            partyId.get("partyId")
                    );
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;

    }






    public class Token
    {

        private String access_token;


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