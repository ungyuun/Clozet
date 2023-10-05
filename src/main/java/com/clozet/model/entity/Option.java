package com.clozet.model.entity;

import lombok.*;

import javax.persistence.*;


@Builder
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "option")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prodNo", referencedColumnName = "prodNo")
    private Product product; // 외래 키를 참조하는 관계 설정
    private String size;
    private Long price;
    private Long amount;

    @Override
    public String toString() {
        return "Option{" +
                "idx=" + idx +
                ", product=" + product +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
