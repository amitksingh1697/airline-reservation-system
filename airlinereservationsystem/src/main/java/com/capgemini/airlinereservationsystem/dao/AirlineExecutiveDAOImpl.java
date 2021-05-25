package com.capgemini.airlinereservationsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.airlinereservationsystem.beans.AirlineExecutiveBeans;
import com.capgemini.airlinereservationsystem.beans.FlightBooking;
import com.capgemini.airlinereservationsystem.beans.FlightInformation;

@Repository
public class AirlineExecutiveDAOImpl implements AirlineExecutiveDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public AirlineExecutiveBeans viewFlightOccupancy(String flightNumber) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		AirlineExecutiveBeans executive = new AirlineExecutiveBeans();

		FlightInformation flightInformation = new FlightInformation();
		flightInformation = manager.find(FlightInformation.class, flightNumber);
		String FlightNumber = flightInformation.getFlightNumber();
		int availableFirstClassSeats = flightInformation.getFirstClassSeats();
		int availableBussinessClassSeats = flightInformation.getBussinessClassSeats();

		FlightBooking flightBooking = new FlightBooking();
		String jpql = "select SUM(passengers) from FlightBooking where flightNumber = :flightNumber and classType = Bussiness";

		System.err.println(flightBooking);

		String classType = flightBooking.getClassType();
		int passengers = flightBooking.getPassengers();
		System.err.println("passengers : " + passengers);

		if (classType.equalsIgnoreCase("Bussiness")) {
			int totalBussinessClassSeats = availableBussinessClassSeats + passengers;
			System.out.println("totalBussinessClassSeats: " + totalBussinessClassSeats);
			executive.setTotalBussinessClassSeats(totalBussinessClassSeats);

		} else if (classType.equalsIgnoreCase("First Class")) {
			int totalFirstClassSeats = availableFirstClassSeats + passengers;
			System.out.println("totalFirstClassSeats: " + totalFirstClassSeats);
			executive.setTotalBussinessClassSeats(totalFirstClassSeats);
		}
		executive.setFlightNumber(flightNumber);
		executive.setAvailableFirstClassSeats(availableFirstClassSeats);
		executive.setAvailableBussinessClassSeats(availableBussinessClassSeats);
		// manager.persist(executive);
		manager.close();
		return executive;
	}

}
