package com.cyramsolutions.flight_reservation.controllers;

import com.cyramsolutions.flight_reservation.dto.ReservationUpdateRequest;
import com.cyramsolutions.flight_reservation.entities.Reservation;
import com.cyramsolutions.flight_reservation.repos.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        LOGGER.info("Inside findReservation() for id: " + id);
        return reservationRepository.getOne(id);
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        LOGGER.info("Inside updateReservation() for " + request);
        Reservation reservation = reservationRepository.getOne(request.getId());
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.isCheckedIn());
        LOGGER.info("Saving Reservation");
        return reservationRepository.save(reservation);
    }

}
