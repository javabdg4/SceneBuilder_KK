package com.sda.sceneBuilder.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PersonJson {
    private String name;
    private String lastname;
    private String street;
    private String city;
    private String postalCode;
    private String telephone;

    public PersonJson() {
    }

    public PersonJson(String name, String lastname, String street, String city, String postalCode, String telephone) {
        this.name = name;
        this.lastname = lastname;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
