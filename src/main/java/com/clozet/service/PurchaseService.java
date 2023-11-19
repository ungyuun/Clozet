package com.clozet.service;

import com.clozet.model.dto.PurchaseDto;
import com.clozet.model.entity.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.text.ParseException;

public interface PurchaseService {
	
	public PurchaseDto addPurchase(PurchaseDto purchaseDto);


	Page<Purchase> getPurchaseList(String email, Pageable pageable);

//	public String getToken();
//
//	public String paymentInfo(String imp_uid, String access_token) throws IOException, ParseException;
}
