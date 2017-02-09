package xyz.codingmentor.web.jpa.hw.ejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Krisz
 */
@Entity
@Table(name = "actor")
public class ActorEntity implements Serializable {

    @Id
    private Integer id;
    private String firstname;
    private String lastname;
    private String nationality;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "jnd_actor_film",
            joinColumns = @JoinColumn(name = "actor_fk"),
            inverseJoinColumns = @JoinColumn(name = "film_fk"))
    private List<FilmEntity> films;

    public ActorEntity() {
        //empty on purpose
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<FilmEntity> getFilms() {
        return films;
    }

    public void setFilms(List<FilmEntity> films) {
        this.films = films;
    }

}
