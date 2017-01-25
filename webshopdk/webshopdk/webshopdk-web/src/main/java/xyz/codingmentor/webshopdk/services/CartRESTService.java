package xyz.codingmentor.webshopdk.services;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.webshopdk.dtos.ResultDTO;
import xyz.codingmentor.webshopdk.dtos.ResultType;
import xyz.codingmentor.webshopdk.entities.ShoppingCart;

/**
 *
 * @author Krisz
 */
@Path("shoppingcart")
@SessionScoped
@Produces(MediaType.APPLICATION_JSON)
public class CartRESTService implements Serializable {

    @Inject
    private ShoppingCart sCart;

    @POST
    @Path("/add/{deviceId}/{quantity}")
    public ResultDTO addToCart(@Context HttpServletRequest request, @PathParam("deviceId") String deviceId, @PathParam("quantity") Integer quantity) {
        HttpSession session = request.getSession(true);
        checkLogin(session);
        sCart.addDeviceToCart(deviceId, quantity);
        return new ResultDTO(ResultType.SUCCESS, "Successfully added to the cart device with ID: " + deviceId + " quantity: " + quantity);
    }

    @POST
    @Path("/remove/{deviceId}/{quantity}")
    public ResultDTO removeFromCart(@Context HttpServletRequest request, @PathParam("deviceId") String deviceId, @PathParam("quantity") Integer quantity) {
        HttpSession session = request.getSession(true);
        checkLogin(session);
        sCart.removeDeviceFromCart(deviceId, quantity);
        return new ResultDTO(ResultType.SUCCESS, "Successfully removed from cart device with ID: " + deviceId + "  quantity: " + quantity);
    }

    @GET
    @Path("/buy")
    public ResultDTO buyCart(@Context HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        checkLogin(session);
        sCart.buyCart();
        return new ResultDTO(ResultType.SUCCESS, "Cart is bought.");
    }

    private static void checkLogin(HttpSession session) {
        if (session.getAttribute(UserRESTService.USER_KEY) == null) {
            throw new IllegalArgumentException("You are not logged in!");
        }
    }
}
