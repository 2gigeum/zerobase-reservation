package com.zerobase.tablereservation.controller;

import com.zerobase.tablereservation.model.Partner;
import com.zerobase.tablereservation.service.PartnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PartnerController {
    private final PartnerService partnerService;


    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }


    @PostMapping("/create/partnerRegister") // 파트너 등록
    public void createPartner(
            @RequestPart String shopName,
            @RequestPart String address,
            @RequestPart String contact,
            @RequestPart String category

    ) {

        partnerService.savePartner(shopName, address, contact, category);
    }

    @GetMapping("/read/partners") //파트너 목록 확인
    public List<Partner> readPartner() {
        return partnerService.readPartners();
    }

    @PutMapping("/update/partner") //파트너 id로 연락처 등 수정
    public void updatePartner(Long id, @RequestParam String contact) {
        partnerService.updatePartner(id, contact);

    }

    @DeleteMapping("/delete/partner") // 파트너 삭제
    public void deletePartner(@RequestParam Long id) {
        partnerService.deletePartner(id);
    }


}
