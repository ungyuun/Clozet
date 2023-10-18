package com.clozet.model.entity;

import javax.management.relation.Role;
import javax.persistence.*;
import java.sql.Timestamp;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
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
    private String email;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String nickname;


//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    //@JoinColumn(name = "email", referencedColumnName = "email") // email 필드를 참조
//    private List<Cart> cart;


}