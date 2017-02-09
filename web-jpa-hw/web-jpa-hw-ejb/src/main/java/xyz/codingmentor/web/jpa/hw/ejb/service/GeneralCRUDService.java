package xyz.codingmentor.web.jpa.hw.ejb.service;

import xyz.codingmentor.web.jpa.hw.ejb.api.CRUDRepository;
import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;

/**
 *
 * @author Krisz
 * @param <T>
 */
public class GeneralCRUDService<T> {

    private final CRUDRepository<T> repository;

    public GeneralCRUDService(CRUDRepository<T> repository) {
        this.repository = repository;
    }

    public void createEntity(T entity) throws RepositoryException {
        repository.persist(entity);
    }

    public T getEntityById(Integer entityId) throws RepositoryException {
        return repository.find(entityId);
    }

    public T updateEntity(T entity) throws RepositoryException {
        return repository.merge(entity);
    }

    public void removeEntity(Integer entityId) throws RepositoryException {
        repository.remove(entityId);
    }
}
