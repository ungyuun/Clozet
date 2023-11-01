package com.clozet.service;

import com.clozet.model.dto.PurchaseDto;
import com.clozet.model.entity.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PurchaseService {
	
	public PurchaseDto addPurchase(PurchaseDto purchaseDto);


	Page<Purchase> getPurchaseList(String email, Pageable pageable);
}
