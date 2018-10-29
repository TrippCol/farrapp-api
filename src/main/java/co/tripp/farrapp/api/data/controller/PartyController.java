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

        @CrossOrigin(origins = "http://localhost:3000")
        @RequestMapping( value = "/parties", method = RequestMethod.POST )
        public ResponseEntity<?> addParty(@RequestBody Party party ) throws ServletException {
            partyService.addNewParty(party);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        @CrossOrigin(origins = "http://localhost:3000")
        @RequestMapping( value = "/parties", method = RequestMethod.GET )
        public ResponseEntity<?> getPartiesByCategory(@RequestParam("category") String category) {
            return new ResponseEntity<>(partyService.getPartiesByCategory(category),HttpStatus.ACCEPTED);
        }

        @CrossOrigin(origins = "http://localhost:3000")
        @RequestMapping( value = "/parties/", method = RequestMethod.GET )
        public ResponseEntity<?> getPartyList() {
            return new ResponseEntity<>(partyService.getParties(),HttpStatus.ACCEPTED);
        }

        @CrossOrigin(origins = "http://localhost:3000")
        @RequestMapping( value = "/parties/party", method = RequestMethod.POST )
        public ResponseEntity<?> addUserToParty(@RequestBody User user, @RequestBody Party party ) throws ServletException {
            partyService.addNewAssistant(party, user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }






}