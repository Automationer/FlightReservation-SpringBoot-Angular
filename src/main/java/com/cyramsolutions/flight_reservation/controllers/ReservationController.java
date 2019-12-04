package com.cyramsolutions.flight_reservation.controllers;

import com.cyramsolutions.flight_reservation.dto.ReservationRequest;
import com.cyramsolutions.flight_reservation.entities.Flight;
import com.cyramsolutions.flight_reservation.entities.Reservation;
import com.cyramsolutions.flight_reservation.repos.FlightRepository;
import com.cyramsolutions.flight_reservation.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    private final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationService reservationService;

    @RequestMapping("showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
        LOGGER.info("Inside showCompleteReservation(), invoked with flight id: {}", flightId);
        Flight flight = flightRepository.getOne(flightId);
        modelMap.addAttribute("flight", flight);
        LOGGER.info("Flight is: {}", flight);
        return "completeReservation";
    }

    @RequestMapping(value = "completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request, ModelMap modelMap) {
        LOGGER.info("Inside completeReservation() {}", request);
        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg", "Reservation created successfully and " +
                "id is: " + reservation.getId());
        return "reservationConfirmation";
    }


}
