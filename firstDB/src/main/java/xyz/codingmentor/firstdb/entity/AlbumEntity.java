package xyz.codingmentor.firstdb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Krisz
 */
@Entity
@Table(name = "album")
public class AlbumEntity implements Serializable {

    @EmbeddedId
    private AlbumId id;
    @Temporal(TemporalType.DATE)
    private Date publishDate;
    @Enumerated(EnumType.STRING)
    private GenreEnum genre;

    public AlbumEntity() {
        //empty on purpose
    }

    public AlbumEntity(AlbumId id, Date publishDate, GenreEnum genre) {
        this.id = id;
        this.publishDate = publishDate;
        this.genre = genre;
    }

    public AlbumId getId() {
        return id;
    }

    public void setId(AlbumId id) {
        this.id = id;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }


}
