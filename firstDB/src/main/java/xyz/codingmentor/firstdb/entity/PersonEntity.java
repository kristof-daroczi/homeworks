package xyz.codingmentor.firstdb.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Krisz
 */
@Entity
@Table(name = "person")
public class PersonEntity implements Serializable {

    @Id
    private String id;
    private String name;
    private int age;
    private String favouriteAlbum;

    public PersonEntity() {
        //empty on purpose
    }

    public PersonEntity(String id, String name, int age, String favouriteAlbum) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.favouriteAlbum = favouriteAlbum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavouriteAlbum() {
        return favouriteAlbum;
    }

    public void setFavouriteAlbum(String favouriteAlbum) {
        this.favouriteAlbum = favouriteAlbum;
    }

}
