package com.c4c.authn.core.service.impl;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.c4c.authn.BaseServiceTest;
import com.c4c.authn.CommonTest;
import com.c4c.authn.core.service.api.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JWTTokenServiceImplTest extends BaseServiceTest {
    @Autowired
    private TokenService tokenService;

    @Test
    void createSignToken_test_ok(){
        String token =  this.tokenService.createSignToken(CommonTest.getClaims());
        assertNotNull(token);
    }

    @Test
    void createSignRefreshToken_test_ok(){
        String token =  this.tokenService.createSignRefreshToken();
        assertNotNull(token);
    }

    @Test
    void verify_test_ok(){
        String token =  this.tokenService.createSignToken(CommonTest.getClaims());
        DecodedJWT jwt = this.tokenService.verifyToken(token);
        assertNotNull(jwt);
        assertEquals(jwt.getClaim("name").asString(), "sheel");
    }

}
