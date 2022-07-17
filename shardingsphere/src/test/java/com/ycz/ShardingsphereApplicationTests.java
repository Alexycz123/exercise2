package com.ycz;

import com.ycz.entity.SysUser;
import com.ycz.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.util.Date;

@SpringBootTest
class ShardingsphereApplicationTests {

    @Autowired
    private SysUserService userService;

    @Test
    void contextLoads() {



        for (int i = 0; i < 10; i++) {
            SysUser sysUser = new SysUser();
            sysUser.setUsername(String.valueOf(i)+"abc");
            sysUser.setPassword(String.valueOf(i)+"bcd");
            sysUser.setAddress("深圳");
            sysUser.setCreateBy("admin" + i);
            sysUser.setCreateTime(new Date());
            userService.save(sysUser);
        }


    }

}
