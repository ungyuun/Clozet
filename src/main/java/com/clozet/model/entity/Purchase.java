package com.clozet.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

import java.sql.Date;

@Entity
public class Purchase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tranNo;

    private Long rownum;
    @OneToOne
    @JoinColumn(name="userid")
    private User user;

    @OneToOne
    @JoinColumn(name="prodno")
    private Product product;

    private char paymentOption;

    private String receiverName;

    private String receiverPhone;

    private String dlvyAddr;

    private String dlvyRequest;

    private char tranCode;

    private Date orderDate;

    private String dlvyDate;

    public Purchase(Long tranNo, Long rownum, User user, Product product, char paymentOption, String receiverName, String receiverPhone, String dlvyAddr, String dlvyRequest, char tranCode, Date orderDate, String dlvyDate) {
        this.tranNo = tranNo;
        this.rownum = rownum;
        this.user = user;
        this.product = product;
        this.paymentOption = paymentOption;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.dlvyAddr = dlvyAddr;
        this.dlvyRequest = dlvyRequest;
        this.tranCode = tranCode;
        this.orderDate = orderDate;
        this.dlvyDate = dlvyDate;
    }

    public Purchase() {

    }
}
