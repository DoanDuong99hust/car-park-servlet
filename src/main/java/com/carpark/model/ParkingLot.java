package com.carpark.model;

public class ParkingLot extends AbstractModel<ParkingLot>{
	
	private Long parkId;
	private String parkName;
	private String parkPlace;
	private Long parkArea;
	private Long parkPrice;
	private String parkStatus;
	
	public Long getParkId() {
		return parkId;
	}
	public void setParkId(Long parkId) {
		this.parkId = parkId;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getParkPlace() {
		return parkPlace;
	}
	public void setParkPlace(String parkPlace) {
		this.parkPlace = parkPlace;
	}
	public Long getParkArea() {
		return parkArea;
	}
	public void setParkArea(Long parkArea) {
		this.parkArea = parkArea;
	}
	public Long getParkPrice() {
		return parkPrice;
	}
	public void setParkPrice(Long parkPrice) {
		this.parkPrice = parkPrice;
	}
	public String getParkStatus() {
		return parkStatus;
	}
	public void setParkStatus(String parkStatus) {
		this.parkStatus = parkStatus;
	}
	
	
}
