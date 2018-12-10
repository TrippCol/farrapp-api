package co.tripp.farrapp.api.data.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Document
public class Party {
    @Id
    private Integer id;
    private String creator;
    private String partyName;
    private String description;
    private String eventDate;
    private String eventHour;
    private String address;
    private String place;
    private Integer price;
    private List<Item> cartaDeProductos;
    //private String optionalDescription;
    private List<User> assistants;
    private List<String> categories;
    private Integer minAge;
    private String dressCode;
    private Bar bar;
    private static final AtomicInteger idCount = new AtomicInteger(4);


    public Party() {
        this.id = idCount.incrementAndGet();
    }

    public Party(String creator, String partyName, String description, String eventDate, String eventHour, String address, String place, Integer price, List<Item> cartaDeProductos, List<User> assistants, String dressCode, Integer minAge) {
        this.creator = creator;
        this.partyName = partyName;
        this.description = description;
        this.eventDate = eventDate;
        this.eventHour = eventHour;
        this.address = address;
        this.place = place;
        this.price = price;
        //this.optionalDescription = optionalDescription;
        this.assistants = assistants;
        this.dressCode = dressCode;
        this.minAge = minAge;
        this.cartaDeProductos = cartaDeProductos;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventHour() {
        return eventHour;
    }

    public void setEventHour(String eventHour) {
        this.eventHour = eventHour;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Item> getCartaDeProductos() {
        return cartaDeProductos;
    }

    public void setCartaDeProductos(List<Item> cartaDeProductos) {
        this.cartaDeProductos = cartaDeProductos;
    }

    public List<User> getAssistants() {
        return assistants;
    }

    public void setAssistants(List<User> assistants) {
        this.assistants = assistants;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public void addAssistant(User user) {
        this.assistants.add(user);
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public String getDressCode() {
        return dressCode;
    }

    public void setDressCode(String dressCode) {
        this.dressCode = dressCode;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }


    @Override
    public String toString() {
        return "Party{" +
                "id=" + id +
                ", creator='" + creator + '\'' +
                ", partyName='" + partyName + '\'' +
                ", description='" + description + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventHour='" + eventHour + '\'' +
                ", address='" + address + '\'' +
                ", place='" + place + '\'' +
                ", price=" + price +
                ", cartaDeProductos=" + cartaDeProductos +
                ", assistants=" + assistants +
                ", categories=" + categories +
                ", minAge=" + minAge +
                ", dressCode='" + dressCode + '\'' +
                ", bar=" + bar +
                '}';
    }
}
