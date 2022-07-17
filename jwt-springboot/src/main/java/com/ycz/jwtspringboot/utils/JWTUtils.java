package com.ycz.jwtspringboot.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-12-23:57
 * @Version: V1.0
 **/
public class JWTUtils {
    /*
    生成token header.
     */

    private static final String SIGN = "H5!52ASD%212312SDASIDNASC)231+2315AS2DA5D1*-**/+++112312yy&&&@@#$@!";

    public static String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE , 7);

        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        return builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(SIGN));
    }


    public static void verifyToken(String token){
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);

    }
    /**
     * 獲取token的信息
     */

    public static DecodedJWT getTokenInfo(String token){
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }


}
