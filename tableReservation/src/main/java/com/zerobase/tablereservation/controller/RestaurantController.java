package com.zerobase.tablereservation.controller;

import com.zerobase.tablereservation.exception.PartnerNotFoundException;
import com.zerobase.tablereservation.model.Restaurant;
import com.zerobase.tablereservation.repository.PartnerRepository;
import com.zerobase.tablereservation.service.PartnerService;
import com.zerobase.tablereservation.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final PartnerRepository partnerRepository;
    private final PartnerService partnerService;

    public RestaurantController(RestaurantService restaurantService, PartnerRepository partnerRepository, PartnerService partnerService) {
        this.restaurantService = restaurantService;
        this.partnerRepository = partnerRepository;
        this.partnerService = partnerService;
    }



    @PostMapping("/create/restaurantRegister") // 매장등록
    public void createRestaurant(
            @RequestParam Long id,
            @RequestPart String shopName,
            @RequestPart String address,
            @RequestPart String contact,
            @RequestPart String category,
            @RequestPart String notice

    ){
        //파트너 등록 안되어있을시 예외처리
        if(!partnerService.isPartnerRegistered(id)){
            throw new PartnerNotFoundException("Partner Not Found !");
        }
        restaurantService.registerRestaurant(
               id, shopName, address, contact, category, notice);
    }

    @GetMapping("/read/restaurants") //모든 매장목록 검색
    public List<Restaurant> readRestaurants(){
       return restaurantService.readRestaurants();
    }

    @GetMapping("/read/restaurant") // 가게이름으로 매장 검색
    public List<Restaurant> readRestaurant(
            @RequestParam("shopName") String shopName){

        return restaurantService.readRestaurant(shopName);
    }

    @DeleteMapping("/delete/restaurant") // id로 매장 삭제
    public void deleteRestaurant(@RequestParam Long id){
        restaurantService.deleteRestaurant(id);
    }




}
