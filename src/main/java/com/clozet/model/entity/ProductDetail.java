package com.clozet.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productDetail")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    //joincolumn시 prodNo 생성
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "prodNo", referencedColumnName = "prodNo")
    private Product product; // 외래 키를 참조하는 관계 설정
    private String size;
    private Long amount;

}
