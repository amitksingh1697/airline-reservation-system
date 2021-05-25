package com.capgemini.airlinereservationsystem.response;

import java.util.List;

import com.capgemini.airlinereservationsystem.beans.FlightInformation;

public class FlightResponse {
	private int statusCode;
	private String message;
	private String description;
	private FlightInformation flightInformation;
	private List<FlightInformation> searchFlight;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FlightInformation getFlightInformation() {
		return flightInformation;
	}

	public void setFlightInformation(FlightInformation flightInformation) {
		this.flightInformation = flightInformation;
	}

	public List<FlightInformation> getSearchFlight() {
		return searchFlight;
	}

	public void setSearchFlight(List<FlightInformation> searchFlight) {
		this.searchFlight = searchFlight;
	}

}
