package xyz.codingmentor.firstdb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Krisz
 */
@Entity
@Table(name = "publisher")
public class PublisherEntity implements Serializable {

    @Id
    private String id;
    private String name;
    @Embedded
    private PublisherAddress address;
    @OneToMany(fetch = FetchType.EAGER)
    private List<AlbumEntity> albums;

    public PublisherEntity() {
        albums = new ArrayList<>();
    }

    public PublisherEntity(String id, String name, PublisherAddress address) {
        this.id = id;
        this.name = name;
        this.address = address;
        albums = new ArrayList<>();
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

    public PublisherAddress getAddress() {
        return address;
    }

    public void setAddress(PublisherAddress address) {
        this.address = address;
    }

    public List<AlbumEntity> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
    }

}
