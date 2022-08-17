package com.c4c.authn.core.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.c4c.authn.core.service.api.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTTokenServiceImpl implements TokenService {

    public static final String ISSUER = "c4c";
    @Value("${c4c.authn.token.hmac.secret}")
    private String hmacSecret;

    @Value("#{new Long('${c4c.authn.token.expire.duration:120}')}")
    private Long expireDuration;
    private Algorithm algorithm;

    private JWTVerifier verifier;

    private final Map<String, Object> headers = new HashMap<>();
    @PostConstruct
    private void init(){
        algorithm = Algorithm.HMAC256(hmacSecret); //use more secure key
        headers.put("alg", "HS256");
        headers.put("typ", "jwt");

        verifier = JWT.require(algorithm)
                .withIssuer(ISSUER)
                .acceptLeeway(1)   //1 sec for nbf and iat
                .acceptExpiresAt(5)   //5 secs for exp
                .build();
    }

    @Override
    public String createSignToken(Map<String, Object> claims){

        JWTCreator.Builder builder = JWT.create()
                .withIssuer(ISSUER);
        claims.forEach((s, o) -> {
            builder.withClaim(s,o.toString());
        });

        Instant instant = Instant.now();
        return builder.withIssuedAt(instant)
                .withExpiresAt(instant.plus(expireDuration, ChronoUnit.MINUTES))
                .withHeader(this.headers)
                .sign(this.algorithm);

    }

    @Override
    public String createSignRefreshToken(){

        JWTCreator.Builder builder = JWT.create()
                .withIssuer(ISSUER);

        Instant instant = Instant.now();
        return builder.withIssuedAt(instant)
                .withExpiresAt(instant.plus(expireDuration+60, ChronoUnit.MINUTES))
                .withHeader(this.headers)
                .sign(this.algorithm);

    }

    @Override
    public DecodedJWT verifyToken(String token){
        return verifier.verify(token);
    }

}
