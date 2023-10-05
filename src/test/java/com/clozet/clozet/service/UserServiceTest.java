package com.clozet.clozet.service;

import com.clozet.model.dto.UserDto;

import java.util.Map;

public interface UserServiceTest {

    void addUser() throws Exception;

    // 내정보확인 / 로그인
    void getUser() throws Exception;

    // 회원정보리스트
	void getUserList() throws Exception;

    // 회원정보수정
    void updateUser() throws Exception;

    // 회원 ID 중복 확인
    void checkDuplication() throws Exception;
}
