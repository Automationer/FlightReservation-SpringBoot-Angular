package com.cyramsolutions.flight_reservation.controllers;

import com.cyramsolutions.flight_reservation.entities.Flight;
import com.cyramsolutions.flight_reservation.repos.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    private final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("findFlights")
    public String findFlights(@RequestParam("from") String from, @RequestParam("to")
            String to, @RequestParam("dateOfDeparture")
                              @DateTimeFormat(pattern = "MM-dd-yyyy") Date dateOfDeparture, ModelMap modelMap) {
        LOGGER.info("Inside findFlights() \n{} To {}, Departure Date: {}", from, to, dateOfDeparture);
        List<Flight> flights = flightRepository.findFlights(from, to, dateOfDeparture);
        modelMap.addAttribute("flights", flights);
        LOGGER.info("Flights found: {}", flights);
        return "displayFlights";
    }

    @RequestMapping("admin/showAddFight")
    public String showAddFlight() {
        return "addFlight";
    }

}
