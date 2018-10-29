package co.tripp.farrapp.api.data.repositories;

import co.tripp.farrapp.api.data.model.Party;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartyRepository extends MongoRepository<Party, String> {
    Party findById(int id);
}
