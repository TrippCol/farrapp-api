package co.tripp.farrapp.api.data.service;

import co.tripp.farrapp.api.data.model.Party;
import co.tripp.farrapp.api.data.model.User;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Tripp
 */
public interface PartyService
{
    void addNewParty(Party party);

    ConcurrentHashMap<Integer, Party> getParties();

    void addNewAssistant(int idParty, User user);

    List<Party> getPartiesByCategory(String category);

    List<Party> getPartiesByPlace(String place);

    List<Party> getPartiesByCreator(String creator);
}