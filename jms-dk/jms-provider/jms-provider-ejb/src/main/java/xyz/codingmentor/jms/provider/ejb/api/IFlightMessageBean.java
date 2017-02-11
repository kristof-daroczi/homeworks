package xyz.codingmentor.jms.provider.ejb.api;

import xyz.codingmentor.jms.provider.ejb.entity.FlightEntity;

/**
 *
 * @author Krisz
 */
public interface IFlightMessageBean {

    void produceMessageToTopic(String flightMessage);

    void createDeleteMessage(FlightEntity flight);

    void createUpdateMessage(FlightEntity flight);
}
