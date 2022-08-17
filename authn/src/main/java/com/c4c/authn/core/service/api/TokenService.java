package com.c4c.authn.core.service.api;

import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Map;

public interface TokenService {
    String createSignToken(Map<String, Object> claims);

    String createSignRefreshToken();

    DecodedJWT verifyToken(String token);
}
