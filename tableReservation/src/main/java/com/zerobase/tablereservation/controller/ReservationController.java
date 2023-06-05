package com.zerobase.tablereservation.controller;


import com.zerobase.tablereservation.service.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    private final ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping("/create/reservation")
    public void createReservation(
            @RequestPart Long id,
            @RequestPart String shopName,
            @RequestPart String name,
            @RequestPart String contact,
            @RequestPart Long headCount) {
        reservationService.saveReservation(id, shopName,name,contact,headCount);

    }


}
