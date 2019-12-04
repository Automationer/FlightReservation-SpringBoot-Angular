package com.cyramsolutions.flight_reservation;

import com.cyramsolutions.flight_reservation.repos.FlightRepository;
import com.cyramsolutions.flight_reservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FlightReservationApplicationTests {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationRepository reservationRepository;


}
