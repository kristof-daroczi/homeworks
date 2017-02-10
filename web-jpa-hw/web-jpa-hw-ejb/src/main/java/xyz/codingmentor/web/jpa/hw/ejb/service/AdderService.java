package xyz.codingmentor.web.jpa.hw.ejb.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDService;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDServiceQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.EntityModel;
import xyz.codingmentor.web.jpa.hw.ejb.entity.ActorEntity;
import xyz.codingmentor.web.jpa.hw.ejb.entity.CategoryEntity;
import xyz.codingmentor.web.jpa.hw.ejb.entity.FilmEntity;
import xyz.codingmentor.web.jpa.hw.ejb.entity.TrailerEntity;
import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;

/**
 *
 * @author Krisz
 */
@Stateless
public class AdderService {

    @Inject
    @CRUDServiceQualifier(EntityModel.CATEGORY)
    private CRUDService<CategoryEntity> categoryCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.TRAILER)
    private CRUDService<TrailerEntity> trailerCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.ACTOR)
    private CRUDService<ActorEntity> actorCRUDService;

    @Inject
    @CRUDServiceQualifier(EntityModel.FILM)
    private CRUDService<FilmEntity> filmCRUDService;

    public AdderService() {
        //empty on purpose
    }

    public void addCategoryToFilm(Integer filmId, Integer categoryId) throws RepositoryException {

        CategoryEntity category = categoryCRUDService.getEntityById(categoryId);
        FilmEntity film = filmCRUDService.getEntityById(filmId);
        if (film.getCategory() != null) {
            film.setCategory(category);
        }
        filmCRUDService.updateEntity(film);
    }

    public void addTrailerToFilm(Integer filmdId, Integer trailerId) throws RepositoryException {

        FilmEntity film = filmCRUDService.getEntityById(filmdId);
        TrailerEntity trailer = trailerCRUDService.getEntityById(trailerId);
        trailer.setFilm(film);
        trailerCRUDService.updateEntity(trailer);
    }

    public void addFilmToActor(Integer filmdId, Integer actorId) throws RepositoryException {
        FilmEntity film = filmCRUDService.getEntityById(filmdId);
        ActorEntity actor = actorCRUDService.getEntityById(actorId);
        if (actor.getFilms() != null && !actor.getFilms().contains(film)) {
            actor.getFilms().add(film);
            actorCRUDService.updateEntity(actor);
        }
    }
}
