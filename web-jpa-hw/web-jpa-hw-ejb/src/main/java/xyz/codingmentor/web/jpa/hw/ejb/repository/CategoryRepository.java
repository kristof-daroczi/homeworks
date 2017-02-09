package xyz.codingmentor.web.jpa.hw.ejb.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepository;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepositoryQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.EntityModel;
import xyz.codingmentor.web.jpa.hw.ejb.entity.CategoryEntity;

/**
 *
 * @author Krisz
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.CATEGORY)
public class CategoryRepository extends AbstractCRUDRepository<CategoryEntity> implements CRUDRepository<CategoryEntity> {

    @PersistenceContext(unitName = "webjpaPU")
    private EntityManager entityManager;

    @Override
    protected Class<CategoryEntity> getEntityClass() {
        return CategoryEntity.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
