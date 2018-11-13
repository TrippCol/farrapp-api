package co.tripp.farrapp.api.data.controller;

import co.tripp.farrapp.api.data.model.Party;
import co.tripp.farrapp.api.data.model.User;
import co.tripp.farrapp.api.data.service.PartyService;
import co.tripp.farrapp.api.data.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import javax.servlet.ServletException;
import java.util.List;

/**
 * @author Tripp
 */
@RestController
@RequestMapping( "parties" )
public class PartyController
{

        @Autowired
        private PartyService partyService;

        @CrossOrigin(origins = "https://farrapp-frontend.herokuapp.com")
        @RequestMapping( method = RequestMethod.POST )
        public ResponseEntity<?> addParty(@RequestBody Party party ) throws ServletException {
            partyService.addNewParty(party);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @CrossOrigin(origins = "https://farrapp-frontend.herokuapp.com")
        @RequestMapping(value="/creator/{creator}", method = RequestMethod.GET )
        public ResponseEntity<?> getPartiesByCreator(@PathVariable("creator") String creator) {
            return new ResponseEntity<>(partyService.getPartiesByCreator(creator),HttpStatus.ACCEPTED);
        }


        @CrossOrigin(origins = "https://farrapp-frontend.herokuapp.com")
        @RequestMapping( method = RequestMethod.GET )
        public ResponseEntity<?> getPartyList() {
            return new ResponseEntity<>(partyService.getParties(),HttpStatus.ACCEPTED);
        }

        @CrossOrigin(origins = "https://farrapp-frontend.herokuapp.com")
        @RequestMapping( value = "/party/{idParty}", method = RequestMethod.PUT )
        public ResponseEntity<?> addUserToParty(@PathVariable(name = "idParty") int idParty, @RequestBody User user) throws ServletException {
            partyService.addNewAssistant(idParty, user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }






}