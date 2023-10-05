package com.clozet.model.entity;

import lombok.*;

import javax.persistence.*;


@Builder
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "options")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name="prodNo")
    private Product product;    // addProductDto의 prodNo
    private String imgUrl;


}
