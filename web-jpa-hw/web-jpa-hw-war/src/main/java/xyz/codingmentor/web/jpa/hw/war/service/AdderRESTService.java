package xyz.codingmentor.web.jpa.hw.war.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;
import xyz.codingmentor.web.jpa.hw.ejb.service.AdderService;

/**
 *
 * @author Krisz
 */
@Path("adder")
public class AdderRESTService {

    @Inject
    private AdderService adderService;

    public AdderRESTService() {
        //empty on purpose
    }

    @GET
    @Path("categorytofilm")
    public Response addCategoryToFilm(@QueryParam("filmId") Integer filmId, @QueryParam("actorId") Integer actorId) throws RepositoryException {
        adderService.addCategoryToFilm(filmId, actorId);
        return Response.ok().build();
    }

    @GET
    @Path("trailertofilm")
    public Response addTrailerToFilm(@QueryParam("filmId") Integer filmId, @QueryParam("trailerId") Integer trailerId) throws RepositoryException {
        adderService.addTrailerToFilm(filmId, trailerId);
        return Response.ok().build();
    }

    @GET
    @Path("filmtoactor")
    public Response addFilmtoActor(@QueryParam("filmId") Integer filmId, @QueryParam("actorId") Integer actorId) throws RepositoryException {
        adderService.addFilmToActor(filmId, actorId);
        return Response.ok().build();
    }

}
