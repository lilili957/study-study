package com.lilili.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @Author LiYuan
 * @Date 2021/12/21
 **/
@Configuration
public class RedisConfig {

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10));
        return RedisCacheManager.builder(factory).cacheDefaults(cacheConfig).build();
    }

    //redis的序列化和反序列化设置
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        GenericFastJsonRedisSerializer genericFastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
        GenericToStringSerializer<Object> objectGenericToStringSerializer = new GenericToStringSerializer<>(Object.class);

        redisTemplate.setKeySerializer(objectGenericToStringSerializer);
        redisTemplate.setValueSerializer(genericFastJsonRedisSerializer);

        redisTemplate.setHashKeySerializer(objectGenericToStringSerializer);
        redisTemplate.setHashValueSerializer(genericFastJsonRedisSerializer);

        return redisTemplate;

    }
}
