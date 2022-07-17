package com.ycz.mybatis;

import com.ycz.mybatis.entity.User;
import com.ycz.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    void insert2(){
        User user = new User();
        user.setAddress("sz");
        user.setAge(18);
        user.setName("asdasd");
        user.setGender("男");
        user.setEmail("51561651@qq。com");
        user.setQq("asdasd");
        user.setDeleted(0);
        userMapper.insert2("user" , user);
    }

    @Test
    void select(){
        List<User> users = userMapper.selectUser("user", "age");
        users.forEach(System.out::println);
    }

}
