package com.clozet.model.dto;



import com.clozet.model.entity.PurchaseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDto {

	private String paymentId;
	private String merchant_uid;
	private List<CartDto> product;
	private String deleveryOption;
	private String selectedPayment;
	private PurchaseType purchaseType;
	private Long totalPrice;
	private UserDto user;
	private LocalDate regDate;

}