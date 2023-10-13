package com.clozet.security.kakao;

import ch.qos.logback.core.CoreConstants;
import com.clozet.auth.userinfo.KakaoUserInfo;
import com.clozet.model.dto.KakaoTokenDto;
import com.clozet.model.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;


@Component
@Configuration
public class KakaoOAuth2 {

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String clientId;
    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String redirectUri;
    @Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
    private String clientSecret;

    public Map<String,Object> kakaoLogin(String authorizedCode) throws JsonProcessingException {
        System.out.println("kakao : "+authorizedCode);

        KakaoTokenDto kakaoTokenDto = getAccessToken(authorizedCode);
        // 2. 액세스 토큰 -> 카카오 사용자 정보
        Map<String,Object> map = getUserInfoByToken(kakaoTokenDto);

        return map;
    }
    private KakaoTokenDto getAccessToken(String authorizedCode) throws JsonProcessingException {
        // HttpHeader 오브젝트 생성
        System.out.println(clientId);
        System.out.println(redirectUri);
        Map<String, Object> map = new HashMap<>();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HttpBody 오브젝트 생성
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", clientId);
        params.add("redirect_uri", redirectUri);
        params.add("client_secret",clientSecret);
        params.add("code", authorizedCode);

        // HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(params, headers);

        // Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
        ResponseEntity<String> response = restTemplate.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        // JSON -> 액세스 토큰 파싱
        String tokenJson = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        KakaoTokenDto kakaoToken = objectMapper.readValue(tokenJson, KakaoTokenDto.class);
        JSONObject jsonObject = new JSONObject(tokenJson);
        String accessToken = jsonObject.getString("access_token");

        return kakaoToken;
    }
    private Map<String, Object> getUserInfoByToken(KakaoTokenDto kakaoTokenDto) throws JsonProcessingException {
        // HttpHeader 오브젝트 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + kakaoTokenDto.getAccess_token());
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        RestTemplate rt = new RestTemplate();
        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);

        // Http 요청하기 - Post방식으로 - 그리고 response 변수의 응답 받음.
        ResponseEntity<String> response = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );

        JSONObject body = new JSONObject(response.getBody());
        ObjectMapper objectMapper = new ObjectMapper();

        Long id = body.getLong("id");
        String email = body.getJSONObject("kakao_account").getString("email");
        String nickname = body.getJSONObject("properties").getString("nickname");

        Map<String,Object> map = new HashMap<>();
        map.put("UserDto",new UserDto(id, email, nickname));
        map.put("KakaoTokenDto",kakaoTokenDto);

        return map;
    }
}
