package com.ycz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ycz.entity.User;
import com.ycz.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Shardingsphere2ApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    void contextLoads() {
        Page<User> page = new Page<>(0 ,5);
        IPage<User> pageList = userService.page(page);

        pageList.getRecords().forEach(System.out::println);


    }

}
