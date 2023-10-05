package com.clozet.service.impl;

import com.clozet.Mapper.UserMapper;
import com.clozet.model.dto.UserDto;
import com.clozet.model.entity.User;
import com.clozet.repository.UserRepository;
import com.clozet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;




//==> 회원관리 서비스 구현
@Service("userService")
@Transactional()

public class UserServiceImpl implements UserService{

//	@Autowired
	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDto getUser(UserDto userDto) throws Exception {
		User user = UserMapper.INSTANCE.dtoToEntity(userDto);
		return UserMapper.INSTANCE.entityToDto(userRepository.findByUserId(userDto.getUserId()));
	}

	@Override
	public List<UserDto> getUserList(Pageable pageable) throws Exception {

		Page<User> userPage = userRepository.findAll(pageable);
		List<UserDto> userDtoList = userPage.stream().map(UserMapper.INSTANCE::entityToDto).collect(Collectors.toList());
		return userDtoList;
	}

	@Override
	public UserDto addUser(UserDto userDto) throws Exception {
		User user = UserMapper.INSTANCE.dtoToEntity(userDto);
		return UserMapper.INSTANCE.entityToDto(userRepository.save(user));
	}


	public UserDto updateUser(UserDto userDto) throws Exception {
		User user = UserMapper.INSTANCE.dtoToEntity(userDto);
		return UserMapper.INSTANCE.entityToDto(userRepository.save(user));
	}

	public boolean checkDuplication(UserDto userDto) throws Exception {
		boolean result=true;
		User user= userRepository.findByUserId(userDto.getUserId());
		if(user != null) {
			result=false;
		}
		return result;
	}

}