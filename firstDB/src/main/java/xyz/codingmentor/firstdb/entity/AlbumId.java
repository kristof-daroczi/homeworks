package xyz.codingmentor.firstdb.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author Krisz
 */
@Embeddable
public class AlbumId implements Serializable {

    private String compositor;
    private String albumName;

    public AlbumId() {
        //empty on purpose
    }

    public AlbumId(String compositor, String albumName) {
        this.compositor = compositor;
        this.albumName = albumName;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.compositor);
        hash = 97 * hash + Objects.hashCode(this.albumName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlbumId other = (AlbumId) obj;
        if (!Objects.equals(this.compositor, other.compositor)) {
            return false;
        }
        if (!Objects.equals(this.albumName, other.albumName)) {
            return false;
        }
        return true;
    }

}
