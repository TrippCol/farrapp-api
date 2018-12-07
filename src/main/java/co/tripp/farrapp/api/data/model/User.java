package co.tripp.farrapp.api.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String type;
    private List<Party> myParties;

    @Id
    private int id;

    public User() {
    }

    public User(String name, String lastName, String email, String password, int id, String type, List<Party> myParties) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.id = id;
        this.type = type;
        this.myParties = myParties;
    }

    public User(String name, String lastName, String email, String password, int id) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Party> getMyParties() {
        return myParties;
    }

    public void setMyParties(List<Party> myParties) {
        this.myParties = myParties;
    }

    public void addParty(Party party) {
        this.myParties.add(party);
    }

    public void removeParty(int partyId) {
        for (int i = 0; i < this.myParties.size(); i++) {
            if (this.myParties.get(i).getId() == partyId) {
                this.myParties.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", myParties=" + myParties +
                ", id=" + id +
                '}';
    }
}
