package xyz.codingmentor.web.jpa.hw.ejb.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepository;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepositoryQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.EntityModel;
import xyz.codingmentor.web.jpa.hw.ejb.entity.ActorEntity;

/**
 *
 * @author Krisz
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.ACTOR)
public class ActorRepository extends AbstractCRUDRepository<ActorEntity> implements CRUDRepository<ActorEntity> {

    @PersistenceContext(unitName = "webjpaPU")
    private EntityManager entityManager;

    @Override
    protected Class<ActorEntity> getEntityClass() {
        return ActorEntity.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
