package co.tripp.farrapp.api.data.controller;

import co.tripp.farrapp.api.data.model.Party;
import co.tripp.farrapp.api.data.model.User;
import co.tripp.farrapp.api.data.services.party.PartyService;
import co.tripp.farrapp.api.data.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

/**
 * @author Tripp
 */
@RestController
@RequestMapping("parties")
public class PartyController {

    @Autowired
    private PartyService partyService;

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addParty(@RequestBody Party party) throws ServletException {
        partyService.addNewParty(party);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/creator/{creator}", method = RequestMethod.GET)
    public ResponseEntity<?> getPartiesByCreator(@PathVariable("creator") String creator) {
        return new ResponseEntity<>(partyService.getPartiesByCreator(creator), HttpStatus.ACCEPTED);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getPartyList() {
        return new ResponseEntity<>(partyService.getParties(), HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/party/{idParty}", method = RequestMethod.POST)
    public ResponseEntity<?> addUserToParty(@PathVariable(name = "idParty") int idParty, @RequestBody User user) throws ServletException {
        userService.addUserParty(user.getEmail(), partyService.getParty(idParty));
        partyService.addNewAssistant(idParty, user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




}
