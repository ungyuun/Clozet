package com.clozet.repository;

import com.clozet.model.entity.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,String> {

    Page<Purchase> findAllByUserKakaoEmail(String email, Pageable pageable);
}