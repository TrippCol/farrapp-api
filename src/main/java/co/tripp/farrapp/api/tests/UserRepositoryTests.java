package co.tripp.farrapp.api.tests;

import co.tripp.farrapp.api.data.model.User;
import co.tripp.farrapp.api.data.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository repository;

    @Before
    public void init() {
        repository.deleteAll();
        repository.save(new User("Fulano", "Perez", "fulano.perez@mail.escuelaing.edu.co", "fulanito01", 13456578));
        repository.save(new User("Pedro", "Rodriguez", "pedro.rodriguez@hotmail.com", "pedrou", 13456578));
    }

    @Test
    public void findByEmailTest() {
        User user = repository.findByEmail("pedro.rodriguez@hotmail.com");
        assertEquals("Pedro", user.getName());
        User user2 = repository.findByEmail("fulano.perez@mail.escuelaing.edu.co");
        System.out.println(user2.getName());
        assertEquals("Fulano", user2.getName());
    }
}
