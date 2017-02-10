package xyz.codingmentor.web.jpa.hw.ejb.api;

import java.util.List;
import xyz.codingmentor.web.jpa.hw.ejb.entity.ActorEntity;
import xyz.codingmentor.web.jpa.hw.ejb.entity.FilmEntity;
import xyz.codingmentor.web.jpa.hw.ejb.entity.TrailerEntity;
import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;

/**
 *
 * @author Krisz
 */
public interface IQueryService {

    List<FilmEntity> getFilmsbyTitle(String title) throws RepositoryException;

    List<ActorEntity> getActorsByName(String firstname,String lastname) throws RepositoryException;

    List<ActorEntity> getActorsByNationality(String nationality) throws RepositoryException;

    List<TrailerEntity> getTrailersbyFilm(Integer filmId) throws RepositoryException;

}
