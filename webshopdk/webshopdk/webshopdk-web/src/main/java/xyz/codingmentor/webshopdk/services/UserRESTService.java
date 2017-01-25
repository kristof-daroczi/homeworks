package xyz.codingmentor.webshopdk.services;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
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
import xyz.codingmentor.webshopdk.dbs.UserDB;
import xyz.codingmentor.webshopdk.dtos.ResultDTO;
import xyz.codingmentor.webshopdk.dtos.ResultType;
import xyz.codingmentor.webshopdk.entities.UserEntity;
import xyz.codingmentor.webshopdk.exceptions.AuthenticationFailureException;

/**
 *
 * @author Krisz
 */
@Path("/users")
@SessionScoped
@Produces(MediaType.APPLICATION_JSON)
public class UserRESTService implements Serializable {

    public static final String USER_KEY = "user";

    @Inject
    private UserDB userDB;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO login(@Context HttpServletRequest request, UserEntity user) throws AuthenticationFailureException {
        boolean isAuthenticated = userDB.authenticate(user.getUsername(), user.getPassword());
        if (!isAuthenticated) {
            throw new AuthenticationFailureException("Wrong password or username.");
        }
        UserEntity loggedUser = userDB.getUser(user.getUsername());
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(2000);
        session.setAttribute(USER_KEY, loggedUser);
        return new ResultDTO(ResultType.SUCCESS, loggedUser);
    }

    @GET
    @Path("/{username}")
    public UserEntity getUserbyUsername(@PathParam("username") String username) {
        return userDB.getUser(username);
    }

    @GET
    public List<UserEntity> getAllUsers() {
        return userDB.getAllUsers();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO addUser(@Context HttpServletRequest request, UserEntity newUser) {
        HttpSession session = request.getSession();
        if (session.getAttribute(UserRESTService.USER_KEY) == null) {
            throw new IllegalArgumentException("You are not logged in!");
        }
        UserEntity actUser = (UserEntity) session.getAttribute(USER_KEY);
        if (!actUser.isAdmin()) {
            throw new IllegalStateException("You don't have the right permission to do this.(Admin=false)");
        }
        userDB.addUser(newUser);
        return new ResultDTO(ResultType.SUCCESS, newUser);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultDTO deleteUser(@Context HttpServletRequest request, UserEntity user) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute(USER_KEY) == null) {
            throw new IllegalArgumentException("You are not logged in!");
        }
        UserEntity actUser = (UserEntity) session.getAttribute(USER_KEY);
        if (!actUser.isAdmin()) {
            throw new IllegalStateException("You don't have the right permission to do this.(Admin=false)");
        }
        userDB.deleteUser(user);
        return new ResultDTO(ResultType.SUCCESS, user);
    }

    @POST
    @Path("/logout")
    public ResultDTO logout(@Context HttpServletRequest request) {
        UserEntity user = (UserEntity) request.getSession().getAttribute(USER_KEY);
        request.getSession().invalidate();
        return new ResultDTO(ResultType.SUCCESS, user);
    }
}
