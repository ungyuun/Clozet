package com.clozet.service.impl;

import com.clozet.Mapper.PurchaseMapper;
import com.clozet.model.dto.PurchaseDto;
import com.clozet.model.entity.Purchase;
import com.clozet.model.entity.PurchaseList;
import com.clozet.repository.PurchaseRepository;
import com.clozet.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


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
}
