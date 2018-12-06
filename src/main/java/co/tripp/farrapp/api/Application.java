package co.tripp.farrapp.api;

import co.tripp.farrapp.api.data.config.JwtFilter;
import co.tripp.farrapp.api.data.model.User;
import co.tripp.farrapp.api.data.model.Party;
import co.tripp.farrapp.api.data.repositories.PartyRepository;
import co.tripp.farrapp.api.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Bean
    public FilterRegistrationBean jwtFilter()
    {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter( new JwtFilter() );
        registrationBean.addUrlPatterns( "/api/*" );

        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        userRepository.save(new User("Juan David", "Ramirez Mendoza", "juan.ramirez-me@mail.escuelaing.edu.co", "qwerty1", 1020394, "User", null));


        partyRepository.deleteAll();
        /*Party p = new Party("Candy Flip", "Halloween Armando"
                , "Fiesta de disfraces del dia de las brujas"
                , "31/10/2018"
                , "21:00", "Ac. 85 #15-30"
                , "Armando Records"
                , 35000
                , "Premios al mejor disfraz de la noche para hombre y mujer"
                , null
                , "Disfraz"
                ,18
                );
        p.setCategories( Arrays.asList("Electronica", "Latino"));
        p.setId(12);
        partyRepository.save(p);*/
    }

}