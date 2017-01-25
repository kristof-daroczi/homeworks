package xyz.codingmentor.webshopdk.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import xyz.codingmentor.webshopdk.dtos.ResultDTO;
import xyz.codingmentor.webshopdk.dtos.ResultType;

/**
 *
 * @author Krisz
 */
public class AuthenticationFailureExceptionMapper implements ExceptionMapper<AuthenticationFailureException> {

    private static final Logger LOGGER = Logger.getLogger(AuthenticationFailureExceptionMapper.class.getName());

    @Override
    public Response toResponse(AuthenticationFailureException exception) {
        LOGGER.log(Level.SEVERE, "Authentication Exception", exception);
        return Response.status(Response.Status.EXPECTATION_FAILED).entity(new ResultDTO(ResultType.ERROR,
                exception.getMessage())).type(MediaType.APPLICATION_JSON).build();
    }

}
