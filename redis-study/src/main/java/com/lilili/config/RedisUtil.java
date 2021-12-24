package com.lilili.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @Author LiYuan
 * @Date 2021/9/30
 **/
@Component
public class RedisUtil {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public String getRedis(String redisKey) {
        return stringRedisTemplate.opsForValue().get(redisKey);
    }

    public void setRedis(String redisKey, String value) {
        stringRedisTemplate.opsForValue().set(redisKey, value);
    }

    public void setRedis(String redisKey, String value, int seconds) {
        stringRedisTemplate.opsForValue().set(redisKey, value, Duration.ofSeconds(seconds));
    }
}
