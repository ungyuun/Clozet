package com.clozet.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class PurchaseList {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name="paymentId")
    private Purchase purchase;
    private Long prodNo;
    private String title;
    private String thumbnail;
    private String email;
    private String size;
    private Long price;
    private Long amount;

    @Override
    public String toString() {
        return "PurchaseList{" +
                "purchaseId=" + purchaseId +
                ", purchase=" + purchase +
                ", prodNo=" + prodNo +
                ", title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
