package xyz.codingmentor.webshopdk.services;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.webshopdk.dbs.DeviceDB;
import xyz.codingmentor.webshopdk.dtos.ResultDTO;
import xyz.codingmentor.webshopdk.dtos.ResultType;
import xyz.codingmentor.webshopdk.entities.DeviceEntity;
import xyz.codingmentor.webshopdk.entities.UserEntity;

/**
 *
 * @author Krisz
 */
@Path("/devices")
@Produces(MediaType.APPLICATION_JSON)
public class DeviceRESTService implements Serializable {

    @Inject
    private DeviceDB deviceDB;

    @GET
    @Path("/{deviceId}")
    public DeviceEntity getDeviceById(@PathParam("deviceId") String deviceId) {
        return deviceDB.getDevice(deviceId);
    }

    @GET
    public List<DeviceEntity> getAllDevices() {
        return deviceDB.getAllDevice();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO addDevice(@Context HttpServletRequest request, DeviceEntity newDevice) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute(UserRESTService.USER_KEY) == null) {
            throw new IllegalArgumentException("You are not logged in!");
        }
        UserEntity actUser = (UserEntity) session.getAttribute(UserRESTService.USER_KEY);
        if (!actUser.isAdmin()) {
            throw new IllegalStateException("You don't have the right permission to do this.(Admin=false)");
        }
        deviceDB.addDevice(newDevice);
        return new ResultDTO(ResultType.SUCCESS, newDevice);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO deleteDevice(@Context HttpServletRequest request, DeviceEntity device) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute(UserRESTService.USER_KEY) == null) {
            throw new IllegalArgumentException("You are not logged in!");
        }
        UserEntity actUser = (UserEntity) session.getAttribute(UserRESTService.USER_KEY);
        if (!actUser.isAdmin()) {
            throw new IllegalStateException("You don't have the right permission to do this.(Admin=false)");
        }
        deviceDB.deleteDevice(device);
        return new ResultDTO(ResultType.SUCCESS, device);
    }

}
