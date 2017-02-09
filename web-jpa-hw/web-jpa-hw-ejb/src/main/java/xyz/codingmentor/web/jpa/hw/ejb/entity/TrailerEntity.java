package xyz.codingmentor.web.jpa.hw.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Krisz
 */
@Entity
@Table(name = "trailer")
public class TrailerEntity implements Serializable {

    @Id
    private Integer id;
    private String url;
    @Enumerated(EnumType.STRING)
    private TrailerTypeEnum type;
    private String title;
    @Temporal(TemporalType.DATE)
    private Date publishDate;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private FilmEntity film;

    public TrailerEntity() {
        //empty on purpose
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TrailerTypeEnum getType() {
        return type;
    }

    public void setType(TrailerTypeEnum type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public FilmEntity getFilm() {
        return film;
    }

    public void setFilm(FilmEntity film) {
        this.film = film;
    }
    
    
}
