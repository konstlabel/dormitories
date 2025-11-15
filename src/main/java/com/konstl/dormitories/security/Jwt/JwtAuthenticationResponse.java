package com.konstl.dormitories.security.Jwt;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {

    private String accessToken;

    private final String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {

        this.accessToken = accessToken;
    }
}
