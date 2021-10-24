package com.carpark.model;

import java.util.Date;

public class BookingOffice {

	private Long officeId;
	private String officeName;
	private Long tripId;
	private String officePhone;
	private String officePlace;
	private Long officePrice;
	private Date startContractDate;
	private Date endContractDate;
	
	public Long getOfficeId() {
		return officeId;
	}
	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public Long getTripId() {
		return tripId;
	}
	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getOfficePlace() {
		return officePlace;
	}
	public void setOfficePlace(String officePlace) {
		this.officePlace = officePlace;
	}
	public Long getOfficePrice() {
		return officePrice;
	}
	public void setOfficePrice(Long officePrice) {
		this.officePrice = officePrice;
	}
	public Date getStartContractDate() {
		return startContractDate;
	}
	public void setStartContractDate(Date startContractDate) {
		this.startContractDate = startContractDate;
	}
	public Date getEndContractDate() {
		return endContractDate;
	}
	public void setEndContractDate(Date endContractDate) {
		this.endContractDate = endContractDate;
	}
	
	
}
