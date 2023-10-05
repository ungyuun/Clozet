package com.clozet.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionDto {
    private Long idx;
    private Long parentNo;    // addProductDto의 prodNo
    private String size;
    private Long price;
    private Long amount;


}