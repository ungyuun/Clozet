package com.clozet.service;

import com.clozet.model.dto.UserDto;
import com.clozet.model.entity.User;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


public interface UserService {

//	public Map<String,Object> kakaoLogin(String authorizedCode) throws Exception;

	public void register(UserDto userDto) throws Exception;

	public User getUser(HttpServletRequest request);

	void updateUser(HttpServletRequest request, UserDto userDto);



}