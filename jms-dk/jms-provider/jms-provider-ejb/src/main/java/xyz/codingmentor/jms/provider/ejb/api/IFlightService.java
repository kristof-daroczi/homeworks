package xyz.codingmentor.jms.provider.ejb.api;

import java.util.List;
import xyz.codingmentor.jms.provider.ejb.entity.FlightEntity;

/**
 *
 * @author Krisz
 */
public interface IFlightService {

    void createFlight(FlightEntity flight) throws RepositoryException;

    FlightEntity getFlightById(Long flightId) throws RepositoryException;

    FlightEntity updateFlight(FlightEntity flight) throws RepositoryException;

    void deleteFlight(Long flightId) throws RepositoryException;

    List<FlightEntity> getAllFlights() throws RepositoryException;
}
