package xyz.codingmentor.jms.provider.ejb.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jms.provider.ejb.api.IFlightRepository;
import xyz.codingmentor.jms.provider.ejb.api.IFlightService;
import xyz.codingmentor.jms.provider.ejb.api.RepositoryException;
import xyz.codingmentor.jms.provider.ejb.entity.FlightEntity;

/**
 *
 * @author Krisz
 */
@Stateless
public class FlightService implements IFlightService {

    @Inject
    private IFlightRepository flightRepository;

    @Override
    public void createFlight(FlightEntity flight) throws RepositoryException {
        flightRepository.persist(flight);
    }

    @Override
    public FlightEntity getFlightById(Long flightId) throws RepositoryException {
        return flightRepository.findById(flightId);
    }

    @Override
    public FlightEntity updateFlight(FlightEntity flight) throws RepositoryException {
        return flightRepository.update(flight);
    }

    @Override
    public void deleteFlight(Long flightId) throws RepositoryException {
        flightRepository.removeById(flightId);
    }

    @Override
    public List<FlightEntity> getAllFlights() throws RepositoryException {
        return flightRepository.getAllFlights();
    }

}
