package com.clozet.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {



    @Id
    @Column(length=30)
    private String userId;

    @Column(length=30)
    private String userName;

    @Column(length=30)
    private String password;

    @Column(length=20)
    private String role;

    @Column(length=30)
    private String ssn;

    @Column(name="cell_phone")
    private String phone;

    @Column(length=30)
    private String email;

    @Column(name="reg_date")
    private Date regDate;

}
