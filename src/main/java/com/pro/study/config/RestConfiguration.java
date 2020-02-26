package com.pro.study.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
 
/** 
 * @author: wgl
 * @date: 2020年2月25日上午12:37:10 
 * @version:1.0
 * @Description: redis配置类解决redis存取数据不一致 
 * redis保存数据的时候对Key进行了序列化
 */
@Configuration
public class RestConfiguration {
 
    @Autowired
    private RedisTemplate redisTemplate;
 
    @Bean
    public RedisTemplate redisTemplateInit() {
        // key序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //val实例化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        
        return redisTemplate;
    }
}