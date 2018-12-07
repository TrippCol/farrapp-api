package co.tripp.farrapp.api.data.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item {

    private String name;
    private Integer price;

    public Item() {
    }

    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
