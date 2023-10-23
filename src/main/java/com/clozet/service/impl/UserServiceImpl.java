package com.clozet.service.impl;

import com.clozet.Mapper.UserMapper;
import com.clozet.model.dto.UserDto;
import com.clozet.model.entity.User;
import com.clozet.repository.UserRepository;
import com.clozet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;




//==> 회원관리 서비스 구현
@Service("userService")
@Transactional()
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;


//	@Override
//	public Map<String,Object> kakaoLogin(String authorizedCode) throws Exception {
//		return kakaoOAuth2.kakaoLogin(authorizedCode);
//	}

	@Override
	public void register(UserDto userDto) throws Exception {

	}

	public User getUser(HttpServletRequest request) { //(1)
		//(2)
		String kakaoEmail = (String) request.getAttribute("kakaoEmail");

		//(3)
		User user = userRepository.findByKakaoEmail(kakaoEmail);

		//(4)
		return user;
	}


//	public void register(UserDto userDto) throws Exception{
//		String email = userDto.getEmail();
//		User existOwner = (User) userRepository.findByEmail(email).orElse(null);
//		// 처음 로그인이 아닌 경우
//		if (existOwner == null) {
//			User user = UserMapper.INSTANCE.toEntity(userDto);
//			userRepository.save(user);
//		}
//	}
//	public UserDto getUser(UserDto userDto) throws Exception {
//		User user = UserMapper.INSTANCE.dtoToEntity(userDto);
//		return UserMapper.INSTANCE.entityToDto(userRepository.findByUserId(userDto.getUserId()));
//	}
//
//	@Override
//	public List<UserDto> getUserList(Pageable pageable) throws Exception {
//
//		Page<User> userPage = userRepository.findAll(pageable);
//		List<UserDto> userDtoList = userPage.stream().map(UserMapper.INSTANCE::entityToDto).collect(Collectors.toList());
//		return userDtoList;
//	}
//
//
//
//	@Override
//	public UserDto addUser(UserDto userDto) throws Exception {
//		User user = UserMapper.INSTANCE.dtoToEntity(userDto);
//		return UserMapper.INSTANCE.entityToDto(userRepository.save(user));
//	}
//
//
//	public UserDto updateUser(UserDto userDto) throws Exception {
//		User user = UserMapper.INSTANCE.dtoToEntity(userDto);
//		return UserMapper.INSTANCE.entityToDto(userRepository.save(user));
//	}
//
//	public boolean checkDuplication(UserDto userDto) throws Exception {
//		boolean result=true;
//		User user= userRepository.findByUserId(userDto.getUserId());
//		if(user != null) {
//			result=false;
//		}
//		return result;
//	}

}