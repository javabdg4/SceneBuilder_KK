package com.sda.sceneBuilder.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Person {
    private StringProperty name;
    private StringProperty lastname;
    private StringProperty street;
    private StringProperty city;
    private StringProperty postalCode;
    private StringProperty telephone;

    public Person(String name, String lastname, String street, String city, String postalCode, String telephone) {
        this.name = new SimpleStringProperty(name) ;
        this.lastname = new SimpleStringProperty(lastname);
        this.street = new SimpleStringProperty(street);
        this.city = new SimpleStringProperty(city);
        this.postalCode = new SimpleStringProperty(postalCode);
        this.telephone = new SimpleStringProperty(telephone);
    }
}
