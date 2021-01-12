package com.adweak.reference.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author : xuzhaole
 * @date : 2020/11/23
 */

@Repository
public class StringRedisDao {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    public void removeKey(String key) {
        if (redisTemplate.hasKey(key)) {
            redisTemplate.delete(key);
        }
    }

    public void setKey(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setKey(String key, String value, int expireTime, TimeUnit unit) {
        setKey(key, value);
        redisTemplate.expire(key, expireTime, unit);
    }

    public String getValue(String key) {
        if (redisTemplate.hasKey(key)) {
            return redisTemplate.opsForValue().get(key);
        }
        return null;
    }
}
