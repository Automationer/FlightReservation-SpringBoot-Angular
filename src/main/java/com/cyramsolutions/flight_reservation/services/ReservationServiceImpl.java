package com.cyramsolutions.flight_reservation.services;

import com.cyramsolutions.flight_reservation.dto.ReservationRequest;
import com.cyramsolutions.flight_reservation.entities.Flight;
import com.cyramsolutions.flight_reservation.entities.Passenger;
import com.cyramsolutions.flight_reservation.entities.Reservation;
import com.cyramsolutions.flight_reservation.repos.FlightRepository;
import com.cyramsolutions.flight_reservation.repos.PassengerRepository;
import com.cyramsolutions.flight_reservation.repos.ReservationRepository;
import com.cyramsolutions.flight_reservation.utils.EmailUtil;
import com.cyramsolutions.flight_reservation.utils.PDFGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    EmailUtil emailUtil;

    @Override
    @Transactional
    public Reservation bookFlight(ReservationRequest reservationRequest) {
        LOGGER.info("Inside bookFlight()");

        Long flightId = reservationRequest.getFlightId();
        LOGGER.info("Fetching flight id: {}", flightId);

        Flight flight = flightRepository.getOne(flightId);
        Passenger passenger = new Passenger();
        passenger.setFirstName(reservationRequest.getPassengerFirstName());
        passenger.setLastName(reservationRequest.getPassengerLastName());
        passenger.setPhone(reservationRequest.getPassengerPhone());
        passenger.setEmail(reservationRequest.getPassengerEmail());

        LOGGER.info("Saving passenger: {}", passenger);
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        LOGGER.info("Saving the reservation: {}", reservation);
        Reservation savedReservation = reservationRepository.save(reservation);

        LOGGER.info("Generating the itinerary");
        String filePath = "src/main/resources/reservation_itineraries/" + savedReservation.getId() + ".pdf";
        pdfGenerator.generateItinerary(reservation, filePath);
        LOGGER.info("Emailing the itinerary");
        emailUtil.sendItinerary(passenger.getEmail(), filePath);

        return savedReservation;
    }

}
