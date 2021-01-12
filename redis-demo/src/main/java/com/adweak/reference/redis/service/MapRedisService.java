package com.adweak.reference.redis.service;

import com.adweak.reference.redis.dao.MapRedisDao;
import com.adweak.reference.redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.adweak.reference.redis.utils.StringUtil.entityToMap;
import static com.adweak.reference.redis.utils.StringUtil.mapToEntity;

/**
 * @author : xuzhaole
 * @date : 2020/12/4
 */

@Service
public class MapRedisService {

    @Autowired
    private MapRedisDao redisDao;

    public boolean hasKey(String key) {
        return redisDao.hasKey(getMsgProgramKey(key));
    }

    public boolean hasKey(String key, String mapKey) {
        return redisDao.hasKey(getMsgProgramKey(key), mapKey);
    }

    public void put(String key, String mapKey, String value) {
        redisDao.put(getMsgProgramKey(key), mapKey, value);
    }

    public void putAll(String key, User msg) {
        Map map = entityToMap(msg);
        redisDao.putAll(getMsgProgramKey(key), map);
    }
    public void putAll(String key, User msg, int expireTime, TimeUnit unit) {
        Map map = entityToMap(msg);
        redisDao.putAll(getMsgProgramKey(key), map, expireTime, unit);
    }

    public Object get(String key, String mapKey) {
        return redisDao.get(getMsgProgramKey(key), mapKey);
    }

    public User getAll(String key) {
        Map map = redisDao.getAll(getMsgProgramKey(key));
        if (map.isEmpty()) {
            return null;
        }
        User msg = mapToEntity(map, User.class);
        return msg;
    }

    public void del(String key, String mapKey) {
        redisDao.del(getMsgProgramKey(key), mapKey);
    }

    public void delAll(String key) {
        redisDao.delAll(getMsgProgramKey(key));
    }

    public String getMsgProgramKey(String key) {
        return "AWarehouse_deviceMsg_" + key;
    }
}
