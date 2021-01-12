package com.adweak.reference.redis.service;

import com.adweak.reference.redis.dao.StringRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author : xuzhaole
 * @date : 2020/12/3
 */

@Service
public class StringRedisService {

    @Autowired
    private StringRedisDao redisDao;

    public boolean hasKey(String key) {
        return redisDao.hasKey(getVerificationProgramKey(key));
    }

    public void removeKey(String key) {
        redisDao.removeKey(getVerificationProgramKey(key));
    }

    public void setKey(String key, String value) {
        redisDao.setKey(getVerificationProgramKey(key), value);
    }

    public void setKey(String key, String value, int expireTime, TimeUnit unit) {
        redisDao.setKey(getVerificationProgramKey(key), value, expireTime, unit);
    }

    public String getValue(String key) {
        return redisDao.getValue(getVerificationProgramKey(key));
    }

    public String getVerificationProgramKey(String key) {
        return "AWarehouse_verification_" + key;
    }
}
