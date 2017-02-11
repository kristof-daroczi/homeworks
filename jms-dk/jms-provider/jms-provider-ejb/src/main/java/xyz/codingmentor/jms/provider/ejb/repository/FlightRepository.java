package xyz.codingmentor.jms.provider.ejb.repository;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jms.provider.ejb.api.IFlightRepository;
import xyz.codingmentor.jms.provider.ejb.api.RepositoryException;
import xyz.codingmentor.jms.provider.ejb.entity.FlightEntity;

/**
 *
 * @author Krisz
 */
@Stateless
public class FlightRepository implements IFlightRepository {

    @PersistenceContext(unitName = "flightPU")
    private EntityManager entityManager;

    @Override
    public void persist(FlightEntity flight) throws RepositoryException {
        entityManager.persist(flight);
    }

    @Override
    public FlightEntity findById(Long flightId) throws RepositoryException {
        return entityManager.find(FlightEntity.class, flightId);
    }

    @Override
    public FlightEntity update(FlightEntity flight) throws RepositoryException {
        return entityManager.merge(flight);
    }

    @Override
    public void removeById(Long flightId) throws RepositoryException {
        entityManager.remove(flightId);
    }

    @Override
    public List<FlightEntity> getAllFlights() throws RepositoryException {
        return entityManager.createQuery("SELECT flight FROM FlightEntity flight", FlightEntity.class).getResultList();
    }

}
