package com.clozet.model.dto;

import lombok.Data;

@Data
public class KakaoTokenDto {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private String id_token;
    private Long expires_in;
    private Long refresh_token_expires_in;
    private String scope;
}