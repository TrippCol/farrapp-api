package co.tripp.farrapp.api.data.repositories;

import co.tripp.farrapp.api.data.model.Party;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PartyRepository extends MongoRepository<Party, String> {
    Party findById(int id);

    List<Party> findByCategoriesContaining(String category);

    List<Party> findByPlace(String place);

    List<Party> findByCreator(String creator);
}
