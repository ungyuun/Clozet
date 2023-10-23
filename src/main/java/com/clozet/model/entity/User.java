package com.clozet.model.entity;

import javax.management.relation.Role;
import javax.persistence.*;
import java.sql.Timestamp;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//https://sudo-minz.tistory.com/78
//https://growth-coder.tistory.com/188
@Entity
@Getter @ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "kakao_email")
    private String kakaoEmail;

    @Column(name = "kakao_id")
    private Long kakaoId;

    @Column(name = "kakao_profile_img")
    private String kakaoProfileImg;

    @Column(name = "kakao_nickname")
    private String kakaoNickname;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    @Builder
    public User(Long kakaoId, String kakaoProfileImg, String kakaoNickname,
                String kakaoEmail, String userRole) {

        this.kakaoId = kakaoId;
        this.kakaoProfileImg = kakaoProfileImg;
        this.kakaoNickname = kakaoNickname;
        this.kakaoEmail = kakaoEmail;
        this.userRole = userRole;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Cart> cart =  new ArrayList<Cart>();


}