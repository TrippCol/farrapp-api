package co.tripp.farrapp.api.tests;

import co.tripp.farrapp.api.data.model.Party;
import co.tripp.farrapp.api.data.repositories.PartyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartyRepositoryTests {
    @Autowired
    private PartyRepository repository;

    @Before
    public void init() {
        repository.deleteAll();
        Party p1 = new Party("Escudos ECI"
                , "Fiesta realizada despues de la ceremonia de escudos de la Escuela Colombiana de Ingenieria Julio Garavito"
                , "15/11/2018"
                , "22:00", "Ac. 85 #11-53"
                , "Vintrash"
                , 20000
                , "Cover gratis para mujeres"
                , null
                );
        p1.setCategories(Arrays.asList("Crossover", "Electronica"));
        p1.setId(11);
        Party p2 = new Party("Halloween Armando"
                , "Fiesta de disfraces del dia de las brujas"
                , "31/10/2018"
                , "21:00", "Ac. 85 #15-30"
                , "Armando Records"
                , 35000
                , "Premios al mejor disfraz de la noche para hombre y mujer"
                , null
                );
        p2.setCategories(Arrays.asList("Electronica", "Latino"));
        p2.setId(12);
        repository.save(p1);
        repository.save(p2);
    }

    @Test
    public void findByIdTest() {
        Party party = repository.findById(11);
        assertTrue("Escudos ECI".equals(party.getPartyName()));
        Party party2 = repository.findById(12);
        assertTrue("Halloween Armando".equals(party2.getPartyName()));
    }
}

