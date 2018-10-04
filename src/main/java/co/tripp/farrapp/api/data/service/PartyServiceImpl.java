package co.tripp.farrapp.api.data.service;

import co.tripp.farrapp.api.data.model.Party;
import co.tripp.farrapp.api.data.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PartyServiceImpl implements PartyService {
    private ConcurrentHashMap<Integer, Party> parties;
    private User[] asistentes=new User[]{};
    public PartyServiceImpl(){
        parties = new ConcurrentHashMap<>();
    }

    @PostConstruct
    public void populateData(){


            parties.put(1, new Party("FIECI",
                "La mejor fiesta universitaria en Bogotá",
                "31-10-2018",
                "20:00",
                "AK 45 (Autonorte) #205-59, Bogotá, Cundinamarca",
                "Escuela Colombiana De Ingeniería Julio Garavito",
                2000,
                "Fiesta de disfraces",
                "Mix 90's",asistentes ));

    }


    @Override
    public void addNewParty (Party party){
        parties.put(party.getId(),party);
    }


    @Override
    public ConcurrentHashMap<Integer, Party> getParties() {
        return parties;
    }

}
