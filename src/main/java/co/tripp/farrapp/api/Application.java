package co.tripp.farrapp.api;

import co.tripp.farrapp.api.data.config.JwtFilter;
import co.tripp.farrapp.api.data.model.Item;
import co.tripp.farrapp.api.data.model.Party;
import co.tripp.farrapp.api.data.model.User;
import co.tripp.farrapp.api.data.repositories.PartyRepository;
import co.tripp.farrapp.api.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PartyRepository partyRepository;


    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*partyRepository.deleteAll();
        List<User> asistentes=new ArrayList<User>();
        Party armandoHalloween = new Party("Candy FLip", "Armando Halloween",
                "Fiesta realizada el 31 de diciembre para el dia de las brujas",
                "31 de Octubre, 2018",
                "21:00",
                "Ac. 85 #15-30 Bogotá, Colombia",
                "Armando Records",
                0,
                Arrays.asList(new Item("Aguardiente", 90000), new Item("Ginebra Tankeray", 190000), new Item("Ron Medellin", 120000), new Item("Cerveza Corona", 10000)),
                asistentes, "Disfraz", 18);

        armandoHalloween.setCategories( Arrays.asList("electronica", "techno", "house"));
        Party escudosECI = new Party("Escudos 2018 Fb group","Escudos ECI",
                "Fiesta realizada despues de la ceremonia de escudos de la Escuela Colombiana de Ingenieria Julio Garavito, Cover gratis para mujeres",
                "15 de Noviembre de 2018",
                "22:00",
                "Ac. 85 #11-53 Bogotá, Colombia",
                "Vintrash",
                20000,
                Arrays.asList(new Item("Aguardiente", 80000), new Item("Ginebra Bombay", 190000), new Item("Ron Viejo de caldas 3 años", 120000), new Item("Cerveza Club Colombia", 10000)),
                asistentes, "Formal", 18);
        escudosECI.setCategories(Arrays.asList("crossover", "electronica", "reggaeton", "bachata", "salsa", "ranchera", "champeta" ));
        Party finalDeSemestre = new Party("Estudiantes ECI", "Final de semestre",
                "Fiesta organizada para el fin de semestre, Escuela Colombiana de Ingenieria Julio Garavito, Relajate con tus amigos del estres del semestre en Dembow",
                "28 de Noviembre, 2018",
                "21:00",
                "AK 45 (Autonorte) #205-59, Bogotá, Colombia",
                "Dembow",
                20000,
                Arrays.asList(new Item("Aguardiente", 95000), new Item("Ginebra Gordon's", 190000), new Item("Ron Bacardi Limon", 120000), new Item("Gaseosa/Agua", 5000)),
                asistentes, "Casual", 16);
        finalDeSemestre.setCategories(Arrays.asList("crossover","reggaeton","champeta"));
        Party fiECI = new Party("ECI","FIECI",
                "La mejor fiesta universitaria",
                "31 de Octubre, 2018",
                "20:00",
                "AK 45 (Autonorte) #205-59, Bogotá, Colombia",
                "ECI",
                2000,
                Arrays.asList(new Item("Aguardiente", 70000), new Item("Navarro Correas Brut", 90000), new Item("Red Bull", 10000), new Item("Picada", 25000)),
                asistentes, "Casual", 16);
        fiECI.setCategories(Arrays.asList("crossover"));
        fiECI.setId(1);
        finalDeSemestre.setId(2);
        escudosECI.setId(3);
        armandoHalloween.setId(4);

        partyRepository.save(fiECI);
        partyRepository.save(finalDeSemestre);
        partyRepository.save(escudosECI);
        partyRepository.save(armandoHalloween);


        userRepository.deleteAll();
        List<User> usersMongo =  new ArrayList<>();

        List<Party> myPartiesTest = new ArrayList<>();
        Party myParty = new Party("Candy FLip", "Armando Halloween",
                "Fiesta realizada el 31 de diciembre para el dia de las brujas",
                "31 de Octubre, 2018",
                "21:00",
                "Ac. 85 #15-30 Bogotá, Colombia",
                "Armando Records",
                0,
                Arrays.asList(new Item("Aguardiente", 90000), new Item("Ginebra Tankeray", 190000), new Item("Ron Medellin", 120000), new Item("Cerveza Corona", 10000)),
                null, "Disfraz", 18);
        myParty.setId(4);
        myPartiesTest.add(myParty);
        User u1 = new User(
                "Juan David",
                "Ramirez Mendoza",
                "juan.ramirez-me@mail.escuelaing.edu.co",
                "qwerty1",
                1019139950,
                "User",
                myPartiesTest
        );



        User u2 = new User(
                "Kevin Jeffrey",
                "Mendieta Perez",
                "kevin.mendieta@mail.escuelaing.edu.co",
                "qwerty2",
                1020456768,
                "Admin", new ArrayList<>()
        );

        User u3 = new User(
                "Nicolas",
                "Osorio Arias",
                "nicolas.osorio@mail.escuelaing.edu.co",
                "qwerty3",
                234542311,
                "User", new ArrayList<>()
        );

        usersMongo.add(u1);
        usersMongo.add(u2);
        usersMongo.add(u3);

        userRepository.saveAll(usersMongo);*/

    }

}