package com.cyramsolutions.flight_reservation.services;

import com.cyramsolutions.flight_reservation.dto.ReservationRequest;
import com.cyramsolutions.flight_reservation.entities.Reservation;

public interface ReservationService {

    Reservation bookFlight(ReservationRequest reservationRequest);

}
