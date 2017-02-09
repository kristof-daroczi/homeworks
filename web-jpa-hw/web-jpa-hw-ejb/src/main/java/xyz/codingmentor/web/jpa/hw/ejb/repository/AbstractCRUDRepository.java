package xyz.codingmentor.web.jpa.hw.ejb.repository;

import javax.persistence.EntityManager;
import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepository;

/**
 *
 * @author Krisz
 * @param <T>
 */
public abstract class AbstractCRUDRepository<T> implements CRUDRepository<T> {

    protected abstract Class<T> getEntityClass();

    protected abstract EntityManager getEntityManager();

    public AbstractCRUDRepository() {
        //empty on purpose
    }

    @Override
    public void persist(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public T find(Integer entityId) {
        return getEntityManager().find(getEntityClass(), entityId);
    }

    @Override
    public T merge(T entity) {
        return getEntityManager().merge(entity);
    }

    @Override
    public void remove(Integer entityId) {
        getEntityManager().remove(find(entityId));
    }

}
