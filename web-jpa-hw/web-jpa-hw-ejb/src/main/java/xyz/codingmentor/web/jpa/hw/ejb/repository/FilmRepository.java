package xyz.codingmentor.web.jpa.hw.ejb.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepository;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepositoryQualifier;
import xyz.codingmentor.web.jpa.hw.ejb.api.EntityModel;
import xyz.codingmentor.web.jpa.hw.ejb.entity.FilmEntity;

/**
 *
 * @author Krisz
 */
@Stateless
@CRUDRepositoryQualifier(EntityModel.FILM)
public class FilmRepository extends AbstractCRUDRepository<FilmEntity> implements CRUDRepository<FilmEntity> {

    @PersistenceContext(unitName = "webjpaPU")
    private EntityManager entityManager;

    @Override
    protected Class<FilmEntity> getEntityClass() {
        return FilmEntity.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
