package xyz.codingmentor.web.jpa.hw.ejb.api;

import xyz.codingmentor.web.jpa.hw.ejb.exception.RepositoryException;

/**
 *
 * @author Krisz
 * @param <T>
 */
public interface CRUDRepository<T> {
    
    void persist(T entity) throws RepositoryException;
    
    T find(Integer entityId) throws RepositoryException;
    
    T merge(T entity) throws RepositoryException;
    
    void remove(Integer entityId) throws RepositoryException;
}
