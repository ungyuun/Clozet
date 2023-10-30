package com.clozet.model.dto;



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
	private Long totalPrice;
	private UserDto user;
	private LocalDate regDate;

	@Override
	public String toString() {
		return "PurchaseDto{" +
				"paymentId='" + paymentId + '\'' +
				", merchant_uid='" + merchant_uid + '\'' +
				", product=" + product +
				", deleveryOption='" + deleveryOption + '\'' +
				", selectedPayment='" + selectedPayment + '\'' +
				", totalPrice=" + totalPrice +
				", user=" + user +
				'}';
	}
}