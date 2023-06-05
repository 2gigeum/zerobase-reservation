package com.zerobase.tablereservation.service;

import com.zerobase.tablereservation.exception.PartnerNotFoundException;
import com.zerobase.tablereservation.model.Restaurant;
import com.zerobase.tablereservation.repository.PartnerRepository;
import com.zerobase.tablereservation.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final PartnerService partnerService;

    public RestaurantService(RestaurantRepository restaurantRepository, PartnerService partnerService, PartnerRepository partnerRepository) {
        this.restaurantRepository = restaurantRepository;
        this.partnerService = partnerService;

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Restaurant registerRestaurant(
            Long id,
            String shopName,
            String address,
            String contact,
            String category,
            String notice

    ) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(id);
        restaurant.setShopName(shopName);
        restaurant.setAddress(address);
        restaurant.setContact(contact);
        restaurant.setCategory(category);
        restaurant.setNotice(notice);

        restaurantRepository.save(restaurant);

        return restaurant;
    }

    @Transactional(readOnly = true) // 모든 매장 읽기 서비스코드
    public List<Restaurant> readRestaurants() {
        return restaurantRepository.findAll();
    }


    public List<Restaurant> readRestaurant(String shopName) {//가게이름으로 매장 읽기
        return restaurantRepository.findAllByShopName(shopName);
    }

    @Transactional
    public void deleteRestaurant(Long id) {//매장 삭제
        restaurantRepository.deleteAllById(id);
    }


}
