package xyz.codingmentor.web.jpa.hw.war.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDService;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDServiceQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.EntityModel;
import xyz.codingmentor.web.jpa.hw.ejb.entity.FilmEntity;
import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;

/**
 *
 * @author Krisz
 */
@Path("films")
public class FilmRESTService {

    @Inject
    @CRUDServiceQualifier(EntityModel.FILM)
    private CRUDService<FilmEntity> filmService;
    
  
    public FilmRESTService() {
        //empty on purpose
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFilm(FilmEntity film) throws RepositoryException {
        filmService.createEntity(film);
        return Response.ok(film).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findFilmById(@PathParam("id") Integer id) throws RepositoryException {
        FilmEntity film = filmService.getEntityById(id);
        return Response.ok(film).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateFilm(FilmEntity film) throws RepositoryException {
        filmService.updateEntity(film);
        return Response.ok(film).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeFilmById(@PathParam("id") Integer id) throws RepositoryException {
        filmService.removeEntity(id);
        return Response.ok().build();
    }
    
 
}
