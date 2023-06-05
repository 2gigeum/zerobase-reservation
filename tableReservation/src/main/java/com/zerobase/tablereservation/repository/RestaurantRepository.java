package com.zerobase.tablereservation.repository;


import com.zerobase.tablereservation.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    void deleteAllById(Long id);
    List<Restaurant> findAllByShopName(String shopName);
}
