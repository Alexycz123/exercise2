package com.ycz.jwtspringboot.controller;

import com.ycz.jwtspringboot.utils.JWTUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-13-0:13
 * @Version: V1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {


    @PostMapping("/login")
    public Object login(@RequestParam(value = "username")String username,
                        @RequestParam(value = "password")String password
                        ){
        Map<String ,String> map= new HashMap<>();
        map.put("username" , username);
        map.put("password" , password);
        String token = JWTUtils.getToken(map);
        return token;
    }

    @RequestMapping("/index")
    public Object index(){
        return "驗證token成功，進來了主頁面";
    }




}
