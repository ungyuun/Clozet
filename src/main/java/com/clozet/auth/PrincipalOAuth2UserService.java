package com.clozet.auth;


import com.clozet.auth.PrincipalDetails;
import com.clozet.auth.userinfo.KakaoUserInfo;
import com.clozet.auth.userinfo.OAuth2UserInfo;
import com.clozet.model.entity.Role;
import com.clozet.model.entity.User;
import com.clozet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//
//        OAuth2User oAuth2User = super.loadUser(userRequest);
//
//        OAuth2UserInfo oAuth2UserInfo = null;
//        String provider = userRequest.getClientRegistration().getRegistrationId();
//
//        if(provider.equals("kakao")){	//추가
//            oAuth2UserInfo = new KakaoUserInfo(oAuth2User.getAttributes());
//        }
//
//        String providerId = oAuth2UserInfo.getProviderId();
//        String username = provider+"_"+providerId;
//
//        String uuid = UUID.randomUUID().toString().substring(0, 6);
//        String password = bCryptPasswordEncoder.encode("패스워드"+uuid);
//
//        String email = oAuth2UserInfo.getEmail();
//        Role role = Role.ROLE_USER;
//
//        User byUsername = userRepository.findByUsername(username);
//
//        //DB에 없는 사용자라면 회원가입처리
//        if(byUsername == null){
//            byUsername = User.oauth2Register()
//                    .username(username).password(password).email(email).role(role)
//                    .provider(provider).providerId(providerId)
//                    .build();
//            userRepository.save(byUsername);
//        }
//
//        return new PrincipalDetails(byUsername, oAuth2UserInfo);
//    }
}