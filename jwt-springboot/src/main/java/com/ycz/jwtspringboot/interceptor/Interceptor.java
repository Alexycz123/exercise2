package com.ycz.jwtspringboot.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycz.jwtspringboot.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SignatureException;
import java.util.HashMap;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-13-0:20
 * @Version: V1.0
 **/
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        HashMap<String,Object> map = new HashMap<>();
        try {
            JWTUtils.verifyToken(token);
            map.put("state" , true);
            map.put("msg" , "請求成功");
            return true;
        }catch (SignatureVerificationException e){
            e.printStackTrace();
            map.put("msg" , "無效簽名");
        }catch (TokenExpiredException e){
            e.printStackTrace();
            map.put("msg" , "時間過期");
        } catch (AlgorithmMismatchException e){
            e.printStackTrace();
            map.put("msg" , "算法錯誤");
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg" , "token無效");
        }

        map.put("state"  , false);
        String s = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(s);

        return false;
    }
}
