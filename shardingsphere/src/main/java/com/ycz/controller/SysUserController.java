package com.ycz.controller;

import com.ycz.entity.SysUser;
import com.ycz.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-23-11:27
 * @Version: V1.0
 **/
@RestController
@RequestMapping("user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysUserController {

    private final SysUserService userService;

    @RequestMapping("/list")
    public Object list(){
        Map<String  , Object> map = new HashMap<>();
        List<SysUser> list = userService.list();
        map.put("list" , list);
        map.put("total" , list.size());
        return map;
    }

    @RequestMapping("/insert")
    public Object insert(){
            SysUser sysUser = new SysUser();
            sysUser.setUsername("abc");
            sysUser.setPassword("bcd");
            sysUser.setAddress("深圳");
            sysUser.setAge((int) (new Random(100).nextInt()+1));
            sysUser.setCreateBy("admin");
            sysUser.setCreateTime(new Date());
            userService.save(sysUser);
            return "OK";
    }

//    @RequestMapping("/update")
//    public Object update(){
//        SysUser sysUser = new SysUser();
//        sysUser.setId(1539862725117722626L);
//        sysUser.setAge(1231);
//        sysUser.setUpdateTime(new Date());
//        sysUser.setUpdateBy("admin");
//        userService.updateById(sysUser);
//
//        return "OK";
//
//    }

}
