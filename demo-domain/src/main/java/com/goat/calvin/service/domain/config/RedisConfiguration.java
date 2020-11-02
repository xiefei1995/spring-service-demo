package com.goat.calvin.service.domain.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author xiefei15
 * @version 1.0.0
 * @since 2020/9/15 15:32
 */
@SpringBootConfiguration
@ConditionalOnClass({RedisOperations.class})
@EnableConfigurationProperties({RedisProperties.class})
public class RedisConfiguration {

        @Bean
        @ConditionalOnMissingBean({RedisTemplate.class})
        public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
            RedisTemplate<Object, Object> template = new RedisTemplate();
            FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
            template.setValueSerializer(fastJsonRedisSerializer);
            template.setHashValueSerializer(fastJsonRedisSerializer);
            template.setKeySerializer(new StringRedisSerializer());
            template.setHashKeySerializer(new StringRedisSerializer());
            template.setConnectionFactory(redisConnectionFactory);
            return template;
        }

        @Bean
        @ConditionalOnMissingBean({StringRedisTemplate.class})
        public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
            StringRedisTemplate template = new StringRedisTemplate();
            FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
            template.setValueSerializer(fastJsonRedisSerializer);
            template.setHashValueSerializer(fastJsonRedisSerializer);
            template.setConnectionFactory(redisConnectionFactory);
            return template;
        }
}
