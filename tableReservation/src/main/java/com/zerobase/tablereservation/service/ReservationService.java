package com.zerobase.tablereservation.service;

import com.zerobase.tablereservation.model.Reservation;
import com.zerobase.tablereservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;


    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Reservation saveReservation(
            Long id,
            String shopName,
            String name,
            String contact,
            Long headCount
    ) {
        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setShopName(shopName);
        reservation.setName(name);
        reservation.setContact(contact);
        reservation.setHeadCount(headCount);

        reservationRepository.save(reservation);
        return reservation;
    }


}
