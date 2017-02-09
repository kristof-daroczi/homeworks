package xyz.codingmentor.web.jpa.hw.ejb.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepository;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepositoryQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.EntityModel;
import xyz.codingmentor.web.jpa.hw.ejb.entity.TrailerEntity;

/**
 *
 * @author Krisz
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.TRAILER)
public class TrailerRepository extends AbstractCRUDRepository<TrailerEntity> implements CRUDRepository<TrailerEntity>{

    @PersistenceContext(unitName = "webjpaPU")
    private EntityManager entityManager;

    @Override
    protected Class<TrailerEntity> getEntityClass() {
        return TrailerEntity.class;
    }

    @Override
    protected EntityManager getEntityManager() {
      return entityManager;
    }

}
