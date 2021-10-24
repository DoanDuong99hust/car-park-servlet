package com.carpark.model;

import java.sql.Date;
import java.sql.Time;

public class Trip {

	private Long tripId;
	private String bookedTicketNumber;
	private String carType;
	private Date departureDate;
	private Time departureTime;
	private String destination;
	private String diver;
	private Integer maximunOnlineTicketNumber;
	
	public Long getTripId() {
		return tripId;
	}
	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}
	public String getBookedTicketNumber() {
		return bookedTicketNumber;
	}
	public void setBookedTicketNumber(String bookedTicketNumber) {
		this.bookedTicketNumber = bookedTicketNumber;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Time getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDiver() {
		return diver;
	}
	public void setDiver(String diver) {
		this.diver = diver;
	}
	public Integer getMaximunOnlineTicketNumber() {
		return maximunOnlineTicketNumber;
	}
	public void setMaximunOnlineTicketNumber(Integer maximunOnlineTicketNumber) {
		this.maximunOnlineTicketNumber = maximunOnlineTicketNumber;
	}
	
	
	
}
