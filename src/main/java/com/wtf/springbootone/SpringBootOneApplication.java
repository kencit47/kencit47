package com.wtf.springbootone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@EnableCaching
public class SpringBootOneApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SpringBootOneApplication.class, args);
    }

}
