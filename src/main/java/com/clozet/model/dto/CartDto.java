package com.clozet.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private Long prodNo;
    private String email;
    private String size;
    private Long price;
    private Long amount;

    @Override
    public String toString() {
        return "CartDto{" +
                "prodNo=" + prodNo +
                ", email='" + email + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
