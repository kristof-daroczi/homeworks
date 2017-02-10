package xyz.codingmentor.web.jpa.hw.ejb.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import xyz.codingmentor.web.jpa.hw.ejb.entity.ActorEntity;
import xyz.codingmentor.web.jpa.hw.ejb.entity.FilmEntity;
import xyz.codingmentor.web.jpa.hw.ejb.entity.TrailerEntity;
import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;
import xyz.codingmentor.web.jpa.hw.ejb.api.IQueryService;

/**
 *
 * @author Krisz
 */
@Stateless
public class QueryService implements IQueryService {

    @PersistenceContext(unitName = "webjpaPU")
    private EntityManager entityManager;

    public QueryService() {
        //empty on purpose
    }

    @Override
    public List<FilmEntity> getFilmsbyTitle(String title) throws RepositoryException {
        String selectQuery = "SELECT film FROM FilmEntity film WHERE film.title = :title ";
        TypedQuery<FilmEntity> query = entityManager.createQuery(selectQuery, FilmEntity.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Override
    public List<ActorEntity> getActorsByFilm(String filmTitle) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ActorEntity> getActorsByNationality(String nationality) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TrailerEntity> getTrailersbyFilm(String filmTitle) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
