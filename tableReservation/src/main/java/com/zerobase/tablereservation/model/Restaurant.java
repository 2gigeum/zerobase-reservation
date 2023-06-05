package com.zerobase.tablereservation.model;

import com.zerobase.tablereservation.model.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Restaurant {
    @Id
    private Long id;

    @Column(nullable = false)
    private String shopName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String notice;






}
