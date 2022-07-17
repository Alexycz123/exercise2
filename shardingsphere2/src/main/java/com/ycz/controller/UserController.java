package com.ycz.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ycz.entity.User;
import com.ycz.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final IUserService userService;

    @GetMapping("/insert")
    public boolean insert() {
        User user = new User();
        user.setName("啊实打实的撒");
        user.setAge(new Random().nextInt(100)+1);
        System.out.println(user);
        return userService.save(user);
    }

    @GetMapping("/select")
    public Object select(@RequestParam(value = "pageNo" ,required = false , defaultValue = "0")Integer pageNo ,
                         @RequestParam(value ="pageSize" ,required = false , defaultValue = "5")Integer pageSize) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age");
        Page<User> page = new Page<>(pageNo  , pageSize);

        IPage<User> pageList = userService.page(page ,queryWrapper);

        return pageList;
    }

    @GetMapping("/select/{id}")
    public Object getById(@PathVariable String id){
        return userService.getById(id);
    }

    @GetMapping("/update/{id}")
    public Object update(@PathVariable String id){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().set(User::getName , "大萨达十大");
        updateWrapper.eq("id" , id);
        return userService.update(updateWrapper);
    }
}
