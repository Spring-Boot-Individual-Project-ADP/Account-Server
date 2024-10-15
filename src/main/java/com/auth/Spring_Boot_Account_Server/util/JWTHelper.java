package com.auth.Spring_Boot_Account_Server.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class JWTHelper {
    /*
     * https://github.com/auth0/java-jwt
     */
    public static String createToken(String scopes) {

        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            long fiveHoursInMillis = 1000 * 60 * 60 * 5;
            Date expireDate = new Date(System.currentTimeMillis() + fiveHoursInMillis);
            String token = JWT.create()
                    .withSubject("apiuser")
                    .withIssuer("me@me.com")
                    .withClaim("scopes", scopes)
                    .withExpiresAt(expireDate)
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            return null;
        }
    }
}