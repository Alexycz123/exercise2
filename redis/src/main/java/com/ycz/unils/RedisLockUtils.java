package com.ycz.unils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collections;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-01-21:00
 * @Version: V1.0
 **/
@Component
public class RedisLockUtils {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final Long LOCK_REDIS_TIMEOUT =100L;
    private static final Long LOCK_REDIS_WAIT =500L;

    public Boolean getLock(String key ,String value){
        return this.redisTemplate.opsForValue().setIfAbsent(key , value , Duration.ofSeconds(LOCK_REDIS_TIMEOUT));
    }

    public Long releaseLock(String key , String value){
        String luaString  = "if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        DefaultRedisScript<Long> longDefaultRedisScript = new DefaultRedisScript<>(luaString, Long.class);
        Long execute = redisTemplate.execute(longDefaultRedisScript, Collections.singletonList(key), value);
        return execute;
    }
}
