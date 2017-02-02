package xyz.codingmentor.firstdb.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Krisz
 */
@Embeddable
public class PublisherAddress implements Serializable {

    private String city;
    private String street;
    private String country;
    private int streetNumber;

    public PublisherAddress() {
        //empty on purpose
    }

    public PublisherAddress(String country, String city, String street, int streetNumber) {
        this.city = city;
        this.street = street;
        this.country = country;
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

}
