package xyz.codingmentor.web.jpa.hw.war.service;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import xyz.codingmentor.web.jpa.hw.ejb.entity.FilmEntity;
import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;
import xyz.codingmentor.web.jpa.hw.ejb.api.IQueryService;
import xyz.codingmentor.web.jpa.hw.ejb.entity.ActorEntity;
import xyz.codingmentor.web.jpa.hw.ejb.entity.TrailerEntity;

/**
 *
 * @author Krisz
 */
@Path("queries")
public class QueryRESTService {

    @Inject
    private IQueryService queryRepository;

    public QueryRESTService() {
        //empty on purpose
    }

    @GET
    @Path("filmsbytitle")
    public Response getFilmsByTitle(@QueryParam("title") String title) throws RepositoryException {
        List<FilmEntity> resultList = queryRepository.getFilmsbyTitle(title);
        GenericEntity<List<FilmEntity>> entity = new GenericEntity<List<FilmEntity>>(resultList) {
        };
        return Response.ok(entity).build();
    }

    @GET
    @Path("actorsbyname")
    public Response getActorsByName(@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname) throws RepositoryException {
        List<ActorEntity> resultList = queryRepository.getActorsByName(firstname, lastname);
        GenericEntity<List<ActorEntity>> entity = new GenericEntity<List<ActorEntity>>(resultList) {
        };
        return Response.ok(entity).build();
    }

    @GET
    @Path("actorsbynationality")
    public Response getActorsByNationality(@QueryParam("nationality") String nationality) throws RepositoryException {
        List<ActorEntity> resultList = queryRepository.getActorsByNationality(nationality);
        GenericEntity<List<ActorEntity>> entity = new GenericEntity<List<ActorEntity>>(resultList) {
        };
        return Response.ok(entity).build();
    }

    @GET
    @Path("trailersbyfilm")
    public Response getTrailersbyFilm(@QueryParam("filmId") Integer filmId) throws RepositoryException {
        List<TrailerEntity> resultList = queryRepository.getTrailersbyFilm(filmId);
        GenericEntity<List<TrailerEntity>> entity = new GenericEntity<List<TrailerEntity>>(resultList) {
        };
        return Response.ok(entity).build();
    }
}
