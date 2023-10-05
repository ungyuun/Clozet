package com.clozet.service.impl;

import com.clozet.model.entity.Purchase;
import com.clozet.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("purchaseServiceImpl")
@Transactional()
public class PurchaseServiceImpl implements PurchaseService {
    @Override
    public void addPurchase(Purchase purchase) throws Exception {

    }

    @Override
    public Purchase getPurchase(int no) throws Exception {
        return null;
    }

    @Override
    public int updatePurchase(Purchase purchase) throws Exception {
        return 0;
    }

    @Override
    public void updateTranCode(Purchase purchase) throws Exception {

    }

    @Override
    public Map<String, Object> getPurchaseList(Map<String, Object> purchaseMap) throws Exception {
        return null;
    }
//
//	@Autowired
//	@Qualifier("purchaseDaoImpl")
//	private PurchaseDao purchaseDao;
//
//	public void setPurchaseDao(PurchaseDao purchaseDao) {
//		this.purchaseDao = purchaseDao;
//	}
//
//	public PurchaseServiceImpl() {
//		System.out.println(this.getClass());
//	}
//
//	public void addPurchase(Purchase purchase) throws Exception{
//		purchaseDao.addPurchase(purchase);
//
//	}
//
//
//	public Purchase getPurchase(int prodNo) throws Exception {
//		return purchaseDao.getPurchase(prodNo);
//	}
//
//
//	public Map<String, Object> getPurchaseList(Map<String,Object> purchaseMap) throws Exception {
//		List<Purchase> list= purchaseDao.getPurchaseList(purchaseMap);
//		int totalCount = purchaseDao.getTotalCount((Search)purchaseMap.get("search"));
//
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("list", list );
//		map.put("totalCount", new Integer(totalCount));
//
//		return map;
//
//	}
//
//	public int updatePurchase(Purchase purchase) throws Exception {
//		return purchaseDao.updatePurchase(purchase);
//	}
//
//
//	public void updateTranCode(Purchase purchase) throws Exception {
//		purchaseDao.updateTranCode(purchase);
//	}
}
