package xyz.codingmentor.jms.provider.ejb.message;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import xyz.codingmentor.jms.provider.ejb.api.IFlightMessageBean;
import xyz.codingmentor.jms.provider.ejb.api.IFlightService;
import xyz.codingmentor.jms.provider.ejb.api.RepositoryException;
import xyz.codingmentor.jms.provider.ejb.entity.FlightEntity;

/**
 *
 * @author Krisz
 */
@Singleton
@Startup
public class SchedulerChecker {

    private IFlightMessageBean flightMessageBean;
    private IFlightService flightService;

    public SchedulerChecker() {
        //empty on purpose
    }

    @Inject
    public SchedulerChecker(IFlightMessageBean flightMessageBean, IFlightService flightService) {
        this.flightMessageBean = flightMessageBean;
        this.flightService = flightService;
    }

    private static Date getPlusOneHourDate() {
        GregorianCalendar date = new GregorianCalendar();
        date.add(GregorianCalendar.HOUR_OF_DAY, 1);
        return date.getTime();
    }

    @Schedule(hour = "*")
    public void noticeAboutDeparture() throws RepositoryException {
        Date actDate = new Date();
        Date plusOneHourDate = getPlusOneHourDate();
        List<FlightEntity> flights = flightService.getAllFlights();
        for (FlightEntity flight : flights) {
            Date depDate = flight.getDeparture();
            if (depDate.after(actDate) && depDate.before(plusOneHourDate)) {
                flightMessageBean.produceMessageToTopic("Flight will take off within 1 hour." + flight.toString());
            }
        }
    }

}
