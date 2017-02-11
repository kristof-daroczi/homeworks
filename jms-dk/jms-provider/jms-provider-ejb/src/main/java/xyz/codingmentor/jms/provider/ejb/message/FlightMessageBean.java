package xyz.codingmentor.jms.provider.ejb.message;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import xyz.codingmentor.jms.provider.ejb.api.IFlightMessageBean;
import xyz.codingmentor.jms.provider.ejb.entity.FlightEntity;

/**
 *
 * @author Krisz
 */
@Stateless
public class FlightMessageBean implements IFlightMessageBean {

    @Inject
    private JMSContext context;

    @Resource(lookup = "jms/airTopic")
    private Topic topic;

    @Override
    public void produceMessageToTopic(String flightMessage) {
        context.createProducer().send(topic, flightMessage);
    }

    @Override
    public void createDeleteMessage(FlightEntity flight) {
        String message = "Flight has been deleted: " + flight.toString();
        produceMessageToTopic(message);
    }

    @Override
    public void createUpdateMessage(FlightEntity flight) {
        String message = "Flight has been modified : " + flight.toString();
        produceMessageToTopic(message);
    }
}
