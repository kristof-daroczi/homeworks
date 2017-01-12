package xyz.codingmentor.javaresthw.service;

import xyz.codingmentor.javaresthw.dto.UserEntity;
import xyz.codingmentor.javaresthw.singleton.UsersSingleton;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Krisz
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserRESTService {

    //http://localhost:8080/javaresthw-web/rest/users
    @GET
    public Collection<UserEntity> getUsers() {
        return UsersSingleton.INSTANCE.getUsers();
    }

    //http://localhost:8080/javaresthw-web/rest/users
    //JSON: testJSON.json in the root map
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity addUUIDandAddtoMap(UserEntity user) {
        return UsersSingleton.INSTANCE.addUUIDandAddtoMap(user);
    }

    //http://localhost:8080/javaresthw-web/rest/users/{id}
    @GET
    @Path("/{id}")
    public UserEntity getUserbyID(@PathParam("id") String id) {
        return UsersSingleton.INSTANCE.findUserbyID(id);
    }

    //http://localhost:8080/javaresthw-web/rest/users/{id}
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity checkUserID(@PathParam("id") String id, UserEntity user) {
        if (!user.getId().equals(id)) {
            throw new IllegalArgumentException("ID error");
        }

        return UsersSingleton.INSTANCE.updateUser(user);
    }

    //http://localhost:8080/javaresthw-web/rest/users/{id}
    @DELETE
    @Path("/{id}")
    public UserEntity deleteUserbyID(@PathParam("id") String id) {
        return UsersSingleton.INSTANCE.deleteUser(id);
    }

}
