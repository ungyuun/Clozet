package com.clozet.service.impl;

import com.clozet.Mapper.PurchaseMapper;
import com.clozet.model.dto.PurchaseDto;
import com.clozet.model.entity.Product;
import com.clozet.model.entity.Purchase;
import com.clozet.model.entity.PurchaseList;
import com.clozet.repository.PurchaseRepository;
import com.clozet.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Override
    public PurchaseDto addPurchase(PurchaseDto purchaseDto) {
        Purchase purchase = purchaseRepository.save(PurchaseMapper.INSTANCE.toEntity(purchaseDto));
        System.out.println("28 : "+purchase.toString());
        return PurchaseMapper.INSTANCE.toDto(purchase);
    }
    @Override
    public Page<Purchase> getPurchaseList(String email, Pageable pageable) {
        Page<Purchase> purchasePage = purchaseRepository.findAllByUserKakaoEmail(email, pageable);

        // 가져온 Purchase 엔티티들에 대해 purchaseList를 로드합니다
        purchasePage.getContent().forEach(purchase -> {
            purchase.getPurchaseList().size(); // purchaseList를 로드
        });

        return purchasePage;
    }
}
