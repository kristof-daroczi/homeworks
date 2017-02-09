package xyz.codingmentor.web.jpa.hw.war.exception;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;
import xyz.codingmentor.web.jpa.hw.war.dto.ResultDTO;
import xyz.codingmentor.web.jpa.hw.war.dto.ResultType;

/**
 *
 * @author Krisz
 */
@Provider
public class RepositoryExceptionMapper implements ExceptionMapper<RepositoryException> {

    private static final Logger LOGGER = Logger.getLogger(GeneralExceptionMapper.class.getName());

    @Override
    public Response toResponse(RepositoryException throwable) {
        LOGGER.log(Level.SEVERE, "General Exception", throwable);
        return Response.status(Response.Status.EXPECTATION_FAILED).entity(new ResultDTO(ResultType.ERROR,
                throwable.getMessage() + " - " + throwable.getCause())).type(MediaType.APPLICATION_JSON).build();
    }

}
