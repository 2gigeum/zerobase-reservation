package com.zerobase.tablereservation.repository;

import com.zerobase.tablereservation.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.servlet.http.Part;
import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long> {


    Partner findAllById(Long id);

    void deleteAllById(Long Id);

}
