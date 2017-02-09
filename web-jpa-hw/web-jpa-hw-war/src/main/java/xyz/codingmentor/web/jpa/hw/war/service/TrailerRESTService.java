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
import xyz.codingmentor.web.jpa.hw.ejb.entity.TrailerEntity;
import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;

/**
 *
 * @author Krisz
 */
@Path("trailers")
public class TrailerRESTService {

    @Inject
    @CRUDServiceQualifier(EntityModel.TRAILER)
    private CRUDService<TrailerEntity> trailerService;

    public TrailerRESTService() {
        //empty on purpose
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrailer(TrailerEntity trailer) throws RepositoryException {
        trailerService.createEntity(trailer);
        return Response.ok(trailer).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTrailerById(@PathParam("id") Integer id) throws RepositoryException {
        TrailerEntity trailer = trailerService.getEntityById(id);
        return Response.ok(trailer).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTrailer(TrailerEntity trailer) throws RepositoryException {
        trailerService.updateEntity(trailer);
        return Response.ok(trailer).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeTrailerById(@PathParam("id") Integer id) throws RepositoryException {
        trailerService.removeEntity(id);
        return Response.ok().build();
    }
}
