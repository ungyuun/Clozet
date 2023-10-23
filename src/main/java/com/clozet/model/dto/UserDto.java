package com.clozet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@Getter @Builder
public class UserDto {

    String kakaoEmail;
    Long kakaoId;
    String kakaoProfileImg;
    String kakaoNickname;
    String userRole;
    Timestamp createTime;

}
