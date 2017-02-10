package xyz.codingmentor.web.jpa.hw.war.service;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.web.jpa.hw.ejb.entity.FilmEntity;
import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;
import xyz.codingmentor.web.jpa.hw.ejb.service.QueryService;
import xyz.codingmentor.web.jpa.hw.ejb.api.IQueryService;

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
    @Path("{title}")
    public Response getFilmsByTitle(@PathParam("title") String title) throws RepositoryException {
        List<FilmEntity> resultList = queryRepository.getFilmsbyTitle(title);
        GenericEntity<List<FilmEntity>> entity = new GenericEntity<List<FilmEntity>>(resultList) {};
        return Response.ok(entity).build();
    }
}
