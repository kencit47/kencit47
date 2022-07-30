package com.wtf.springbootone.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

import static java.util.Optional.ofNullable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("RedisEntity")
public class RedisEntity implements Serializable {
    @Id
    private int id;
    private String name;
    private int qty;
    private long price;
}

@Configuration
@EnableConfigurationProperties
class RedisConfiguration {

    @Bean
    public JedisConnectionFactory connectionFactory() {
        final RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("localhost");
        configuration.setPort(6379);
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final var template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(connectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new JdkSerializationRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        template.setEnableTransactionSupport(true);
        template.afterPropertiesSet();
        return template;
    }
}

@Repository
@RequiredArgsConstructor
class RedisRepository {
    private final RedisTemplate template;

    private static final String HASH_KEY = "RedisEntity";

    public RedisEntity save(final RedisEntity redis) {
        template.opsForHash().put(HASH_KEY, redis.getId(), redis);
        return redis;
    }

    public List findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public RedisEntity findEntityById(final int id) {
        return ofNullable(template.opsForHash().get(HASH_KEY, id))
                .filter(RedisEntity.class::isInstance)
                .map(RedisEntity.class::cast)
                .orElse(null);
    }

    public Long deleteEntity(final int id) {
        return template.opsForHash().delete(HASH_KEY, id);
    }
}
