package xyz.codingmentor.web.jpa.hw.ejb.api;

import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;

/**
 *
 * @author Krisz
 * @param <T>
 */
public interface CRUDService<T> {

    void createEntity(T entity) throws RepositoryException;
    
    T getEntityById(Integer entityId) throws RepositoryException;
    
    T updateEntity(T entity) throws RepositoryException;
    
    void removeEntity(Integer entityId) throws RepositoryException;
    
}
