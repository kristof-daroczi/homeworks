package xyz.codingmentor.jms.provider.web.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Krisz
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(xyz.codingmentor.jms.provider.web.service.FlightRESTService.class);
    }
    
}
