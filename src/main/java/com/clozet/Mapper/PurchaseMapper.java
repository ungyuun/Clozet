package com.clozet.Mapper;


import com.clozet.model.dto.CartDto;
import com.clozet.model.dto.PurchaseDto;
import com.clozet.model.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {
    PurchaseMapper INSTANCE = Mappers.getMapper(PurchaseMapper.class);

    default PurchaseDto toDto(Purchase purchase){
        return PurchaseDto.builder().
                        paymentId(purchase.getPaymentId())
                        .merchant_uid(purchase.getMerchant_uid())
                        .deleveryOption(purchase.getDeleveryOption())
                        .selectedPayment(purchase.getSelectedPayment())
                        .totalPrice(purchase.getTotalPrice())
                        .user(UserMapper.INSTANCE.toDto(purchase.getUser()))
                        .regDate(purchase.getRegDate())
                        .product(PurchaseMapper.INSTANCE.toPurchaseListtoCartDto(purchase.getPurchaseList())).build();

    }

    List<CartDto> toPurchaseListtoCartDto(List<PurchaseList> purchaseList);

    default Purchase toEntity(PurchaseDto purchaseDto) {
        return Purchase.builder()
                .paymentId(purchaseDto.getPaymentId())
                .merchant_uid(purchaseDto.getMerchant_uid())
                .deleveryOption(purchaseDto.getDeleveryOption())
                .selectedPayment(purchaseDto.getSelectedPayment())
                .totalPrice(purchaseDto.getTotalPrice())
                .user(UserMapper.INSTANCE.toEntity(purchaseDto.getUser()))
                .purchaseList(PurchaseMapper.INSTANCE.toCartDtoPurchaseList(purchaseDto.getProduct()))
                .build();
    }

    List<PurchaseList> toCartDtoPurchaseList(List<CartDto> product);

}
