package com.clozet.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDto {
    private Long idx;
    private Long prodNo;    // addProductDto의 prodNo
    private String size;
    private Long amount;


}