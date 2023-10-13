package com.clozet.model.entity;

import javax.management.relation.Role;
import javax.persistence.*;
import java.sql.Timestamp;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
//https://sudo-minz.tistory.com/78
//https://growth-coder.tistory.com/188
@Entity
@Getter @ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {



    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String nickname;


    @Column(nullable = false)
    private String email;




}