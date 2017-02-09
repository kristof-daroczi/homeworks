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
import xyz.codingmentor.web.jpa.hw.ejb.entity.ActorEntity;
import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;

/**
 *
 * @author Krisz
 */
@Path("actors")
public class ActorRESTService {

    @Inject
    @CRUDServiceQualifier(EntityModel.ACTOR)
    private CRUDService<ActorEntity> actorService;

    public ActorRESTService() {
        //empty on purpose
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createActor(ActorEntity actor) throws RepositoryException {
        actorService.createEntity(actor);
        return Response.ok(actor).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findActorById(@PathParam("id") Integer id) throws RepositoryException {
        ActorEntity actor = actorService.getEntityById(id);
        return Response.ok(actor).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateActor(ActorEntity actor) throws RepositoryException {
        actorService.updateEntity(actor);
        return Response.ok(actor).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeActorById(@PathParam("id") Integer id) throws RepositoryException {
        actorService.removeEntity(id);
        return Response.ok().build();
    }
}
