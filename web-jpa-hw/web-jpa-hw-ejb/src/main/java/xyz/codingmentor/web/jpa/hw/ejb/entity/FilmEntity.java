package xyz.codingmentor.web.jpa.hw.ejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Krisz
 */
@Entity
@Table(name = "film")
public class FilmEntity implements Serializable {

    @Id
    private Integer id;
    private String title;
    @ManyToMany(mappedBy = "films", cascade = CascadeType.PERSIST)
    private List<ActorEntity> actors;
    @OneToMany(mappedBy = "film", cascade = CascadeType.PERSIST)
    private List<TrailerEntity> trailers;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CategoryEntity category;

    public FilmEntity() {
        //empty on purpose
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ActorEntity> getActors() {
        return actors;
    }

    public void setActors(List<ActorEntity> actors) {
        this.actors = actors;
    }

    public List<TrailerEntity> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailerEntity> trailers) {
        this.trailers = trailers;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
    
    

}
