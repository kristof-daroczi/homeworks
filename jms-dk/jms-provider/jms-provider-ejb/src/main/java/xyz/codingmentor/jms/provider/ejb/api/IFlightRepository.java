package xyz.codingmentor.jms.provider.ejb.api;

import java.util.List;
import xyz.codingmentor.jms.provider.ejb.entity.FlightEntity;

/**
 *
 * @author Krisz
 */
public interface IFlightRepository {

    void persist(FlightEntity flight) throws RepositoryException;

    FlightEntity findById(Long flightId) throws RepositoryException;

    FlightEntity update(FlightEntity flight) throws RepositoryException;

    void removeById(Long flightId) throws RepositoryException;

    List<FlightEntity> getAllFlights() throws RepositoryException;

}
