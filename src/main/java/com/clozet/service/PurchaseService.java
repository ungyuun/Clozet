package com.clozet.service;

import com.clozet.model.entity.Purchase;

import java.util.Map;

public interface PurchaseService {
	
	public void addPurchase(Purchase purchase) throws Exception;
	
	public Purchase getPurchase(int no)  throws Exception;
	
	
	

	public int updatePurchase(Purchase purchase) throws Exception;
	
	public void updateTranCode(Purchase purchase) throws Exception;

	public Map<String, Object> getPurchaseList(Map<String, Object> purchaseMap) throws Exception;
}
