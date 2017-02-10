package xyz.codingmentor.web.jpa.hw.ejb.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Krisz
 */
@Entity
@Table(name = "category")
public class CategoryEntity implements Serializable {

    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<FilmEntity> films;

    public CategoryEntity() {
        //empty on purpose
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<FilmEntity> getFilms() {
        return films;
    }

    public void setFilms(List<FilmEntity> films) {
        this.films = films;
    }
    
}
