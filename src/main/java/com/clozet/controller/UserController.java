package com.clozet.controller;

import com.clozet.Mapper.UserMapper;
import com.clozet.model.dto.ProductDto;
import com.clozet.model.dto.UserDto;
import com.clozet.model.entity.User;
import com.clozet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


//==> 회원관리 Controller
@RestController
@RequestMapping("/api/user/*")
public class UserController {

	@Autowired
	private UserService userService;


	@GetMapping("/")
    public ResponseEntity<?> getUser(HttpServletRequest request){
		User user = userService.getUser(request);
		return ResponseEntity.status(HttpStatus.OK).body(UserMapper.INSTANCE.toDto(user));
    }
	@PutMapping("/")
	public ResponseEntity<?> updateUser(HttpServletRequest request,@RequestBody UserDto userDto){
		System.out.println(userDto.toString());
		userService.updateUser(request,userDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}