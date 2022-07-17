import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-12-23:38
 * @Version: V1.0
 **/
public class Test1 {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND , 200);

        String token = JWT.create().withHeader(map)
                .withClaim("userId", 21)
                .withClaim("username", "admin")
                .withExpiresAt(instance.getTime())//指定令牌的過期時間
                .sign(Algorithm.HMAC256("adsasdasdasdasd"));

        System.out.println(token);
    }

    @Test
    public void test2(){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("adsasdasdasdasd")).build();


        DecodedJWT verify =
                jwtVerifier.
                        verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NTUwNDkwNjgsInVzZXJJZCI6MjEsInVzZXJuYW1lIjoiYWRtaW4ifQ.ByQZVvkSEr2LTnXV5zahJ2Y-9wKY4Itk5UlvPZofzhE");



        System.out.println(verify.getPayload());
        System.out.println(verify.getHeader());
        System.out.println(verify.getSignature());
        System.out.println(verify.getClaim("userId").asInt());
        System.out.println(verify.getClaim("username").asString());
    }
}
