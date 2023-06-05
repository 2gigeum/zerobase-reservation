package com.zerobase.tablereservation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String shopName;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String contact;
    @Column(nullable = false)
    private Long headCount;


}
