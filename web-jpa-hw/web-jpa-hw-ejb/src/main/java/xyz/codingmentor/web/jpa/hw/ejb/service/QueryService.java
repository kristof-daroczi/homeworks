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
    public List<ActorEntity> getActorsByName(String firstname, String lastname) throws RepositoryException {
        String selectQuery = "SELECT actor FROM ActorEntity actor WHERE actor.firstname = :firstname AND actor.lastname = :lastname";
        TypedQuery<ActorEntity> query = entityManager.createQuery(selectQuery, ActorEntity.class);
        query.setParameter("firstname", firstname);
        query.setParameter("lastname", lastname);
        return query.getResultList();
    }

    @Override
    public List<ActorEntity> getActorsByNationality(String nationality) throws RepositoryException {
        String selectQuery = "SELECT actor FROM ActorEntity actor WHERE actor.nationality = :nationality";
        TypedQuery<ActorEntity> query = entityManager.createQuery(selectQuery, ActorEntity.class);
        query.setParameter("nationality", nationality);
        return query.getResultList();
    }

    @Override
    public List<TrailerEntity> getTrailersbyFilm(Integer filmId) throws RepositoryException {
        String selectQuery = "SELECT trailer FROM TrailerEntity trailer WHERE trailer.film.id=:filmId ";
        TypedQuery<TrailerEntity> query = entityManager.createQuery(selectQuery, TrailerEntity.class);
        query.setParameter("filmId", filmId);
        return query.getResultList();
    }

}
