package com.tempo.challenge.tenpochallenge.config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.math.BigDecimal;
import java.time.Duration;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<Long, BigDecimal> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Long, BigDecimal> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

    /*
    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofMinutes(60))
            .disableCachingNullValues()
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }
*/
    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> builder
            .withCacheConfiguration("ivaCache",
                RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(2)));
    }
}
