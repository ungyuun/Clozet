package com.clozet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@AllArgsConstructor
@Getter
public class UserDto {

    Long id;
    String email;
    String nickname;

//    ///Field
//    private String userId;
//    private String userName;
//    private String password;
//    private String role;
//    private String ssn;
//    private String phone;
//    private String addr;
//    private String email;
//    private Date regDate;
//    /////////////// EL 적용 위해 추가된 Field ///////////
//    private String phone1;
//    private String phone2;
//    private String phone3;
//    //////////////////////////////////////////////////////////////////////////////////////////////
//    // JSON ==> Domain Object  Binding을 위해 추가된 부분
//    private String regDateString;
}
