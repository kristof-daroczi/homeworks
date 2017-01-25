package xyz.codingmentor.webshopdk.config;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import xyz.codingmentor.webshopdk.exceptions.AuthenticationFailureExceptionMapper;
import xyz.codingmentor.webshopdk.exceptions.GeneralExceptionMapper;
import xyz.codingmentor.webshopdk.services.CartRESTService;
import xyz.codingmentor.webshopdk.services.DeviceRESTService;
import xyz.codingmentor.webshopdk.services.UserRESTService;

/**
 *
 * @author Krisz
 */
@javax.ws.rs.ApplicationPath("/webresources")
public class ApplicationConfig extends Application {

    private final Set<Class<?>> classes;

    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(UserRESTService.class);
        c.add(DeviceRESTService.class);
        c.add(CartRESTService.class);
        c.add(GeneralExceptionMapper.class);
        c.add(AuthenticationFailureExceptionMapper.class);
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

}
