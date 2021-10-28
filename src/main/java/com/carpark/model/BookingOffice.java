package com.carpark.model;

import java.util.Date;

public class BookingOffice extends AbstractModel<BookingOffice> {

	private Long officeId;
	private String officeName;
	private Long tripId;
	private String officePhone;
	private String officePlace;
	private Long officePrice;
	private String startContractDate;
	private String endContractDate;
	
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
	public String getStartContractDate() {
		return startContractDate;
	}
	public void setStartContractDate(String startContractDate) {
		this.startContractDate = startContractDate;
	}
	public String getEndContractDate() {
		return endContractDate;
	}
	public void setEndContractDate(String endContractDate) {
		this.endContractDate = endContractDate;
	}
	
	
}
