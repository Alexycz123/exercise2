package com.ycz.controller;

import com.ycz.unils.RedisLockUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-01-21:12
 * @Version: V1.0
 **/
@RestController
@Slf4j
public class RedisController {

    @Autowired
    private RedisLockUtils lockUtils;

    //对这个订单的id相关的进行修改，所以要加分布式锁
    @RequestMapping("/order/update/{orderId}")
    public Object orderUpdate(@PathVariable String orderId) throws InterruptedException {//一般是传实体，这个不在意这个细节，到时候可以改成entity.getId
        String key = orderId+":lock";
        String value = UUID.randomUUID().toString();
        Boolean lock = lockUtils.getLock(key, value);
        if (lock){
            log.info("获取到了锁");
            //休息10s，假装为业务逻辑代码，长一点显示效果
            Thread.sleep(10000);
            lockUtils.releaseLock(key , value);

            return "执行成功";
        }else{
            return "请稍后再试";
        }


    }

}
