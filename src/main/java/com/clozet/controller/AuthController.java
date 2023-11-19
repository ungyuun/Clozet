package com.clozet.controller;

import com.clozet.model.dto.KakaoTokenDto;
import com.clozet.model.entity.User;
import com.clozet.security.JwtProperties;
import com.clozet.service.UserService;
import com.clozet.service.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;



    @GetMapping("/login")
    public ResponseEntity<?> LoginPage(HttpServletRequest request){
        String kakaoEmail = (String) request.getAttribute("kakaoEmail");
        if (kakaoEmail!=null){
            User user = userService.getUser(request);
            return ResponseEntity.status(HttpStatus.OK).body("유저코드 : "+user);
        }
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Access Denied. Please authenticate.");

    }
    @GetMapping("/kakao/callback")
    public ResponseEntity getLogin(@RequestParam("code") String code) { //(1)

        System.out.println("code : "+code);
        // 넘어온 인가 코드를 통해 access_token 발급
        KakaoTokenDto kakaoTokenDto = authService.getAccessToken(code);
        System.out.println(kakaoTokenDto);
        //(2)
        // 발급 받은 accessToken 으로 카카오 회원 정보 DB 저장 후 JWT 를 생성
        String jwtToken = authService.SaveUserAndGetToken(kakaoTokenDto.getAccess_token());
        System.out.println("jwtToken : "+jwtToken);
        //(3)
        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);

        //(4)
        return ResponseEntity.ok().headers(headers).body(authService.findProfile(kakaoTokenDto.getAccess_token()));
    }

}
