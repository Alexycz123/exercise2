package com.ycz;

import com.ycz.unils.RedisLockUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private RedisLockUtils redisLockUtils;

    @Test
    void contextLoads() {
        Boolean lock = redisLockUtils.getLock("abc", "abc");
        System.out.println(lock);

        Long aLong = redisLockUtils.releaseLock("abc", "abc");
        System.out.println(aLong);
    }

}
