package out.simplilearnproject.com;

import java.math.BigDecimal;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adminadddata")
public class AdminAddData {
@Id
@GeneratedValue(strategy=GenerationType. IDENTITY)
private long id;

private String name;
private String Source;
private String destination;
private Time destinationtime;
private Time arrivaltime;
private BigDecimal price;


public AdminAddData() {
	
}


public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getSource() {
	return Source;
}


public void setSource(String source) {
	Source = source;
}


public String getDestination() {
	return destination;
}


public void setDestination(String destination) {
	this.destination = destination;
}


public Time getDestinationtime() {
	return destinationtime;
}


public void setDestinationtime(Time destinationtime) {
	this.destinationtime = destinationtime;
}


public Time getArrivaltime() {
	return arrivaltime;
}


public void setArrivaltime(Time arrivaltime) {
	this.arrivaltime = arrivaltime;
}


public BigDecimal getPrice() {
	return price;
}


public void setPrice(BigDecimal price) {
	this.price = price;
}


public AdminAddData(String name, String source, String destination, Time destinationtime, Time arrivaltime,
		BigDecimal price) {
	super();
	this.name = name;
	Source = source;
	this.destination = destination;
	this.destinationtime = destinationtime;
	this.arrivaltime = arrivaltime;
	this.price = price;
}

}
