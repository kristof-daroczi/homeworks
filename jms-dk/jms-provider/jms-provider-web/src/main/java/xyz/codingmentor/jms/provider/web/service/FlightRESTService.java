package xyz.codingmentor.jms.provider.web.service;

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
import xyz.codingmentor.jms.provider.ejb.api.IFlightMessageBean;
import xyz.codingmentor.jms.provider.ejb.api.IFlightService;
import xyz.codingmentor.jms.provider.ejb.api.RepositoryException;
import xyz.codingmentor.jms.provider.ejb.entity.FlightEntity;

/**
 *
 * @author Krisz
 */
@Path("flights")
public class FlightRESTService {

    @Inject
    private IFlightService flightService;

    @Inject
    private IFlightMessageBean flightMessageBean;

    public FlightRESTService() {
        //empty on purpose
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFlight(FlightEntity flight) throws RepositoryException {
        flightService.createFlight(flight);
        return Response.ok(flight).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFlightById(@PathParam("id") Long flightId) throws RepositoryException {
        FlightEntity flight = flightService.getFlightById(flightId);
        return Response.ok(flight).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateFlight(FlightEntity flight) throws RepositoryException {
        FlightEntity updatedFlight = flightService.updateFlight(flight);
        flightMessageBean.createUpdateMessage(flight);
        return Response.ok(updatedFlight).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteFlight(@PathParam("id") Long flightId) throws RepositoryException {
        FlightEntity deletedFlight = flightService.getFlightById(flightId);
        flightMessageBean.createDeleteMessage(deletedFlight);
        flightService.deleteFlight(flightId);
        return Response.ok().build();
    }
}
