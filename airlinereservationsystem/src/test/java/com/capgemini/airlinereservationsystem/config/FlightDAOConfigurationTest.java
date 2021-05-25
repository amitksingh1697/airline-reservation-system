package com.capgemini.airlinereservationsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.airlinereservationsystem.dao.FlightDAO;
import com.capgemini.airlinereservationsystem.dao.FlightDAOJpaImpl;

@Configuration
public class FlightDAOConfigurationTest {
	
	//@Bean("FlightDAO")
	public FlightDAO getFlightDAO() {
		
		return new FlightDAOJpaImpl();
		
	}

}
