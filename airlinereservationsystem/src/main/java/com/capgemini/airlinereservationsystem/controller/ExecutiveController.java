package com.capgemini.airlinereservationsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.airlinereservationsystem.beans.AirlineExecutiveBeans;
import com.capgemini.airlinereservationsystem.response.ExecutiveResponse;
import com.capgemini.airlinereservationsystem.service.AirlineExecutiveService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class ExecutiveController {
	@Autowired
	private AirlineExecutiveService executiveService;
	
	@GetMapping("/getOccupancy")
	public ExecutiveResponse getFlight(String flightNumber) {
		AirlineExecutiveBeans executive = executiveService.viewFlightOccupancy(flightNumber);
		ExecutiveResponse response = new ExecutiveResponse();
		if (executive != null) {
			response.setStatus(210);
			response.setMessage("success");
			response.setDescription("Flight found sucessfully");
			response.setExecutive(executive);
		} else {

			response.setStatus(401);
			response.setMessage("Failed");
			response.setDescription(" Not found.Check whether you have entered unique flight number " + flightNumber);

		}
		return response;

	}// end of getflight()
}
