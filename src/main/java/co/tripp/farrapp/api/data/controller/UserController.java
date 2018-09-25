package co.tripp.farrapp.api.data.controller;

import co.tripp.farrapp.api.data.model.User;
import co.tripp.farrapp.api.data.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;

/**
 * @author Tripp
 */
@RestController
@RequestMapping( "user" )
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
        User user = userService.getUserByEmail( email );

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