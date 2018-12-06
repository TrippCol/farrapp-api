package co.tripp.farrapp.api.data.service;

import co.tripp.farrapp.api.data.model.Party;
import co.tripp.farrapp.api.data.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PartyServiceImpl implements PartyService {
    private ConcurrentHashMap<Integer, Party> parties;
    private List<User> asistentes=new ArrayList<User>();
    public PartyServiceImpl(){
        parties = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void populateData(){

            Party armandoHalloween = new Party("Candy FLip", "Armando Halloween",
                    "Fiesta realizada el 31 de diciembre para el dia de las brujas",
                    "31 de Octubre, 2018",
                    "21:00",
                    "Ac. 85 #15-30 Bogotá, Colombia",
                    "Armando Records",
                    0,
                    "Cover gratis toda la noche para los espiritus mas fiesteros",
                    asistentes, "Disfraz", 18);

            armandoHalloween.setCategories( Arrays.asList("electronica", "techno", "house"));
            Party escudosECI = new Party("Escudos 2018 Fb group","Escudos ECI",
                    "Fiesta realizada despues de la ceremonia de escudos de la Escuela Colombiana de Ingenieria Julio Garavito",
                    "15 de Noviembre de 2018",
                    "22:00",
                    "Ac. 85 #11-53 Bogotá, Colombia",
                    "Vintrash",
                    20000,
                    "Cover gratis para mujeres",
                    asistentes, "Formal", 18);
            escudosECI.setCategories(Arrays.asList("crossover", "electronica", "reggaeton", "bachata", "salsa", "ranchera", "champeta" ));
            Party finalDeSemestre = new Party("Estudiantes ECI", "Final de semestre",
                    "Fiesta organizada para el fin de semestre, Escuela Colombiana de Ingenieria Julio Garavito",
                    "28 de Noviembre, 2018",
                    "21:00",
                    "AK 45 (Autonorte) #205-59, Bogotá, Colombia",
                    "Dembow",
                    20000,
                    "Relajate con tus amigos del estres del semestre en Dembow",
                    asistentes, "Casual", 16);
            finalDeSemestre.setCategories(Arrays.asList("crossover","reggaeton","champeta"));
            Party fiECI = new Party("ECI","FIECI",
                    "La mejor fiesta universitaria",
                    "31 de Octubre, 2018",
                    "20:00",
                    "AK 45 (Autonorte) #205-59, Bogotá, Colombia",
                    "Escuela Colombiana De Ingeniería Julio Garavito",
                    2000,
                    "Fiesta de disfraces",
                    asistentes, "Casual", 16);
            fiECI.setCategories(Arrays.asList("crossover"));
            fiECI.setId(1);
            finalDeSemestre.setId(2);
            escudosECI.setId(3);
            armandoHalloween.setId(4);
            parties.put(1, fiECI);
            parties.put(2, finalDeSemestre);
            parties.put(3, escudosECI);
            parties.put(4, armandoHalloween);

    }


    @Override
    public void addNewParty (Party party){
        parties.put(party.getId(),party);
    }


    @Override
    public ConcurrentHashMap<Integer, Party> getParties() {
        return parties;
    }

    @Override
    public void addNewAssistant(int idParty, User user){
        if(parties.get(idParty).getAssistants().equals(null)){
            parties.get(idParty).setAssistants(Arrays.asList(user));
        }else{
            parties.get(idParty).addAssistant(user);
        }
        
    }

    @Override
    public List<Party> getPartiesByCategory(String category) {
        List<Party> foundParties = new ArrayList<>();
        for(Party p: this.parties.values()){
            if(p.getCategories().contains(category)){
                foundParties.add(p);
            }
        }
        return foundParties;
    }

    @Override
    public List<Party> getPartiesByPlace(String place){
        List<Party> foundParties = new ArrayList<>();
        for(Party p: this.parties.values()){
            if(p.getPlace().equals(place)){
                foundParties.add(p);
            }
        }
        return foundParties;
    }

    @Override
    public List<Party> getPartiesByCreator(String creator) {
        List<Party> foundParties = new ArrayList<>();
        for(Party p: this.parties.values()){
            if(p.getCreator().equals(creator)){
                foundParties.add(p);
            }
        }
        return foundParties;
    }

}
