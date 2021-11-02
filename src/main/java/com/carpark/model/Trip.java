package com.carpark.model;

import java.sql.Date;
import java.sql.Time;

public class Trip extends AbstractModel<Trip>{

	private Long tripId;
	private Integer bookedTicketNumber;
	private String carType;
	private String departureDate;
	private String departureTime;
	private String destination;
	private String driverName;
	private Integer maximumOnlineTicketNumber;
	
	public Long getTripId() {
		return tripId;
	}
	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}
	public Integer getBookedTicketNumber() {
		return bookedTicketNumber;
	}
	public void setBookedTicketNumber(Integer bookedTicketNumber) {
		this.bookedTicketNumber = bookedTicketNumber;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Integer getMaximumOnlineTicketNumber() {
		return maximumOnlineTicketNumber;
	}
	public void setMaximumOnlineTicketNumber(Integer maximumOnlineTicketNumber) {
		this.maximumOnlineTicketNumber = maximumOnlineTicketNumber;
	}
	
	
	
}
