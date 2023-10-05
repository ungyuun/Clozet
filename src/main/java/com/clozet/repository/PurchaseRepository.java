package com.clozet.repository;

import com.clozet.model.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {

}