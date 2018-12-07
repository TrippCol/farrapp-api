package co.tripp.farrapp.api.data.services.party.impl;

import co.tripp.farrapp.api.data.model.Party;
import co.tripp.farrapp.api.data.model.User;
import co.tripp.farrapp.api.data.repositories.PartyRepository;
import co.tripp.farrapp.api.data.services.party.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class MongoPartyService implements PartyService {
    @Autowired
    private PartyRepository partyRepository;

    @Override
    public void addNewParty(Party party) {
        partyRepository.save(party);
    }

    @Override
    public ConcurrentHashMap<Integer, Party> getParties() {
        ConcurrentHashMap<Integer, Party> parties = new ConcurrentHashMap<>();
        List<Party> mongoParties = partyRepository.findAll();
        for(Party p: mongoParties){
            parties.put(p.getId(), p);
        }
        return parties;
    }

    @Override
    public void addNewAssistant(int idParty, User user) {
        Party party = partyRepository.findById(idParty);
        party.addAssistant(user);
        partyRepository.save(party);
    }

    @Override
    public List<Party> getPartiesByCategory(String category) {
        return partyRepository.findByCategoriesContaining(category);
    }

    @Override
    public List<Party> getPartiesByPlace(String place) {
        return partyRepository.findByPlace(place);
    }

    @Override
    public List<Party> getPartiesByCreator(String creator) {
        return partyRepository.findByCreator(creator);
    }
}
