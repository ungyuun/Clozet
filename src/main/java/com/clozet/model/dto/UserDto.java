package com.clozet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter @Builder
public class UserDto {

    String kakaoEmail;
    Long kakaoId;
    String kakaoProfileImg;
    String kakaoNickname;
    String userRole;
    Timestamp createTime;
    String receive;
    String cellPhone;
    String postCode;
    String address;
    String addressDetail;

    @Override
    public String toString() {
        return "UserDto{" +
                "kakaoEmail='" + kakaoEmail + '\'' +
                ", kakaoId=" + kakaoId +
                ", kakaoProfileImg='" + kakaoProfileImg + '\'' +
                ", kakaoNickname='" + kakaoNickname + '\'' +
                ", userRole='" + userRole + '\'' +
                ", createTime=" + createTime +
                ", receive='" + receive + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", postCode=" + postCode +
                ", address='" + address + '\'' +
                ", addressDetail='" + addressDetail + '\'' +
                '}';
    }
}
