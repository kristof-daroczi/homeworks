package xyz.codingmentor.web.jpa.hw.war.config;

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
        resources.add(xyz.codingmentor.web.jpa.hw.war.exception.GeneralExceptionMapper.class);
        resources.add(xyz.codingmentor.web.jpa.hw.war.exception.RepositoryExceptionMapper.class);
        resources.add(xyz.codingmentor.web.jpa.hw.war.service.ActorRESTService.class);
        resources.add(xyz.codingmentor.web.jpa.hw.war.service.AdderRESTService.class);
        resources.add(xyz.codingmentor.web.jpa.hw.war.service.CategoryRESTService.class);
        resources.add(xyz.codingmentor.web.jpa.hw.war.service.FilmRESTService.class);
        resources.add(xyz.codingmentor.web.jpa.hw.war.service.QueryRESTService.class);
        resources.add(xyz.codingmentor.web.jpa.hw.war.service.TrailerRESTService.class);
    }
    
}
