package com.clozet.service;

import com.clozet.model.dto.UserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;


//==> 회원관리에서 서비스할 내용 추상화/캡슐화한 Service  Interface Definition
public interface UserService {

	public Map<String,Object> kakaoLogin(String authorizedCode) throws Exception;

	public void register(UserDto userDto) throws Exception;
	// 회원가입
//	public UserDto addUser(UserDto userDto) throws Exception;
//
//	// 내정보확인 / 로그인
//	public UserDto getUser(UserDto userDto) throws Exception;
//
//	// 회원정보리스트
//	public List<UserDto> getUserList(Pageable pageable) throws Exception;
//
//	// 회원정보수정
//	public UserDto updateUser(UserDto userDto) throws Exception;
//
//	// 회원 ID 중복 확인
//	public boolean checkDuplication(UserDto userDto) throws Exception;



}