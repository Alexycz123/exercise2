package com.ycz.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.github.yitter.idgen.YitIdHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class IdGenerator {
    @Bean
    public IdentifierGenerator identifierGenerator() {
        return entity -> YitIdHelper.nextId();
    }
}
