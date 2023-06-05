package com.zerobase.tablereservation.service;

import com.zerobase.tablereservation.model.Partner;
import com.zerobase.tablereservation.repository.PartnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.Part;
import java.util.List;

@Service
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    // id를 통해 파트너 등록이 되어있는지 확인
    public boolean isPartnerRegistered(Long partnerId) {
        return partnerRepository.existsById(partnerId);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Partner savePartner(
            String shopName, String address,
            String contact, String category

    ) {
        Partner partner = new Partner();
        partner.setShopName(shopName);
        partner.setAddress(address);
        partner.setContact(contact);
        partner.setCategory(category);
        partnerRepository.save(partner);

        return partner;
    }

    @Transactional (readOnly = true)
    public List<Partner> readPartners(){
        return partnerRepository.findAll();
    }


    public void updatePartner(Long id,String contact){
        Partner partner=partnerRepository.findAllById(id);
        partner.setContact(contact);

        partnerRepository.save(partner);
    }
    @Transactional
    public void deletePartner(Long id) {
        partnerRepository.deleteAllById(id);
    }


}
