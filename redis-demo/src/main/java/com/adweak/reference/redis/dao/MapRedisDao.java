package com.adweak.reference.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author : xuzhaole
 * @date : 2020/12/4
 */

@Repository
public class MapRedisDao {

    @Autowired
    @Qualifier(value = "myRedisTemplate")
    private RedisTemplate redisTemplate;

    HashOperations<String, String, Object> hashOp;

    @PostConstruct
    public void postConstruct() {
        hashOp = redisTemplate.opsForHash();
    }

    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    public boolean hasKey(String key, String mapKey) {
        return hashOp.hasKey(key, mapKey);
    }

    public void put(String key, String mapKey, String value) {
        hashOp.put(key, mapKey, value);
    }
    public void put(String key, String mapKey, String value, int expireTime, TimeUnit unit) {
        put(key, mapKey, value);
        redisTemplate.expire(key, expireTime, unit);
    }

    public void putAll(String key, Map map) {
        hashOp.putAll(key, map);
    }
    public void putAll(String key, Map map, int expireTime, TimeUnit unit) {
        putAll(key, map);
        redisTemplate.expire(key, expireTime, unit);
    }

    public Object get(String key, String mapKey) {
        return hashOp.get(key, mapKey);
    }

    public Map getAll(String key) {
        return hashOp.entries(key);
    }

    public void del(String key, String mapKey) {
        hashOp.delete(key, mapKey);
    }

    public void delAll(String key) {
        redisTemplate.delete(key);
    }
}
