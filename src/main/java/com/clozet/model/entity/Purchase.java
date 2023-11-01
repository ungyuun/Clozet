package com.clozet.model.entity;

import com.clozet.model.dto.CartDto;
import com.clozet.model.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Purchase extends BaseEntity  {

    @Id @Column(name = "paymentId")
    private String paymentId;
    private String merchant_uid;
    private String deleveryOption;
    private String selectedPayment;
    private Long totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="paymentId")
    private List<PurchaseList> purchaseList = new ArrayList<>();

    @ManyToOne (fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "kakao_email")
    private User user;


    @Builder
    public Purchase(String paymentId, String merchant_uid, String deleveryOption, String selectedPayment, Long totalPrice, List<PurchaseList> purchaseList, User user) {
        this.paymentId = paymentId;
        this.merchant_uid = merchant_uid;
        this.deleveryOption = deleveryOption;
        this.selectedPayment = selectedPayment;
        this.totalPrice = totalPrice;
        this.purchaseList = purchaseList;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "paymentId='" + paymentId + '\'' +
                ", merchant_uid='" + merchant_uid + '\'' +
                ", deleveryOption='" + deleveryOption + '\'' +
                ", selectedPayment='" + selectedPayment + '\'' +
                ", totalPrice=" + totalPrice +
                ", purchaseList=" + purchaseList +
                ", user=" + user +
                '}';
    }
}
