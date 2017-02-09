package xyz.codingmentor.web.jpa.hw.war.service;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDService;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDServiceQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.EntityModel;
import xyz.codingmentor.web.jpa.hw.ejb.entity.CategoryEntity;
import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;

/**
 *
 * @author Krisz
 */
@Path("categories")
public class CategoryRESTService {

    @Inject
    @CRUDServiceQualifier(EntityModel.CATEGORY)
    private CRUDService<CategoryEntity> categoryService;

    public CategoryRESTService() {
        //empty on purpose
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCategory(CategoryEntity category) throws RepositoryException {
        categoryService.createEntity(category);
        return Response.ok(category).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCategoryById(@PathParam("id") Integer id) throws RepositoryException {
        CategoryEntity category = categoryService.getEntityById(id);
        return Response.ok(category).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCategory(CategoryEntity category) throws RepositoryException {
        categoryService.updateEntity(category);
        return Response.ok(category).build();
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeCategoryById(@PathParam("id") Integer id) throws RepositoryException {
        categoryService.removeEntity(id);
        return Response.ok().build();
    }
}
