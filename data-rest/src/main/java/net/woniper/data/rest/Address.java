package net.woniper.data.rest;

import javax.persistence.Entity;

/**
 * Created by woowahan on 2017. 2. 16..
 */
@Entity
public class Address {

    private String street;
    private String state;
    private String country;

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }
}
