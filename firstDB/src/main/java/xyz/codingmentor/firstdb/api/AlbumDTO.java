package xyz.codingmentor.firstdb.api;

import java.util.Date;
import xyz.codingmentor.firstdb.entity.AlbumId;
import xyz.codingmentor.firstdb.entity.GenreEnum;

/**
 *
 * @author Krisz
 */
public class AlbumDTO {

    private AlbumId id;
    private Date publishDate;
    private GenreEnum genre;

    public AlbumDTO() {
        //empty on purpose
    }

    public AlbumDTO(AlbumId id, Date publishDate, GenreEnum genre) {
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

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }
    
     public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "AlbumDTO{" + "id=" + id.getAlbumName() + " " + id.getCompositor() + " " + ", publishDate=" + publishDate + ", genre=" + genre + '}';
    }
    
}
