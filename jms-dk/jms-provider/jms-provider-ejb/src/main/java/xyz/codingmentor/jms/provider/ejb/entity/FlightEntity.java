package xyz.codingmentor.jms.provider.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Krisz
 */
@Entity
public class FlightEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String source;
    private String destination;
    @Temporal(TemporalType.TIMESTAMP)
    private Date departure;
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrival;

    public FlightEntity() {
        //empty on purpose
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    @Override
    public String toString() {
        return "FlightEntity{" + "id=" + id + ", source=" + source + ", destination=" + destination + ", departure=" + departure + ", arrival=" + arrival + '}';
    }
    
    
}
