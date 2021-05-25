package com.capgemini.airlinereservationsystem.beans;

import javax.persistence.*;

@Entity
@Table(name = "airlineExecutive")
public class AirlineExecutiveBeans {

	@Id
	@Column
	private String flightNumber;

	@Column
	private int totalSeats;

	@Column
	private int totalBussinessClassSeats;

	@Column
	private int totalFirstClassSeats;

	@Column
	private int availableBussinessClassSeats;

	@Column
	private int bookedBussinessClassSeats;

	@Column
	private int availableFirstClassSeats;

	@Column
	private int bookedFirstClassSeats;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getTotalBussinessClassSeats() {
		return totalBussinessClassSeats;
	}

	public void setTotalBussinessClassSeats(int totalBussinessClassSeats) {
		this.totalBussinessClassSeats = totalBussinessClassSeats;
	}

	public int getTotalFirstClassSeats() {
		return totalFirstClassSeats;
	}

	public void setTotalFirstClassSeats(int totalFirstClassSeats) {
		this.totalFirstClassSeats = totalFirstClassSeats;
	}

	public int getAvailableBussinessClassSeats() {
		return availableBussinessClassSeats;
	}

	public void setAvailableBussinessClassSeats(int availableBussinessClassSeats) {
		this.availableBussinessClassSeats = availableBussinessClassSeats;
	}

	public int getBookedBussinessClassSeats() {
		return bookedBussinessClassSeats;
	}

	public void setBookedBussinessClassSeats(int bookedBussinessClassSeats) {
		this.bookedBussinessClassSeats = bookedBussinessClassSeats;
	}

	public int getAvailableFirstClassSeats() {
		return availableFirstClassSeats;
	}

	public void setAvailableFirstClassSeats(int availableFirstClassSeats) {
		this.availableFirstClassSeats = availableFirstClassSeats;
	}

	public int getBookedFirstClassSeats() {
		return bookedFirstClassSeats;
	}

	public void setBookedFirstClassSeats(int bookedFirstClassSeats) {
		this.bookedFirstClassSeats = bookedFirstClassSeats;
	}

}
