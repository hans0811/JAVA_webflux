package com.hans.reactspring.service;

import com.hans.reactspring.model.Reservation;
import reactor.core.publisher.Mono;

/**
 * @author hans
 */
public interface ReservationService {

    Mono<Reservation> getReservation(String id);

    Mono<Reservation> createReservation(Mono<Reservation> reservationMono);

    Mono<Reservation> updateReservation(String id, Mono<Reservation> reservationMono);

    Mono<Boolean> deleteReservation(String id);
}
