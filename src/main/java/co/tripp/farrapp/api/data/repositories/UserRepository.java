package co.tripp.farrapp.api.data.repositories;

import co.tripp.farrapp.api.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
}
