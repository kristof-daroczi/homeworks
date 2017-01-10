/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dto.UserEntity;
import com.mycompany.singleton.UsersSingleton;
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

    @GET
    public Collection<UserEntity> getUsers() {
        return UsersSingleton.INSTANCE.getUsers();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity addUUID(UserEntity user) {
        return UsersSingleton.INSTANCE.addUUID(user);
    }

    @GET
    @Path("/{id}")
    public UserEntity getUserbyID(@PathParam("id") String id) {
        return UsersSingleton.INSTANCE.findUserbyID(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public UserEntity checkUserID(@PathParam("id") String id, UserEntity user) {
        if (!user.getId().equals(id)) {
            throw new IllegalArgumentException("ID error");
        }

        return UsersSingleton.INSTANCE.updateUser(user);
    }

    @DELETE
    @Path("/{id}")
    public UserEntity deleteUserbyID(@PathParam("id") String id) {
        return UsersSingleton.INSTANCE.deleteUser(id);
    }

}
