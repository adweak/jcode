package com.adweak.reference.redis.controller;

import com.adweak.reference.redis.entity.User;
import com.adweak.reference.redis.entity.res.DataRes;
import com.adweak.reference.redis.entity.res.SuccessRes;
import com.adweak.reference.redis.service.MapRedisService;
import com.adweak.reference.redis.service.StringRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : xuzhaole
 * @date : 2020/12/23
 */

@RestController
@RequestMapping(value = "redis")
public class RedisController {

    @Autowired
    private StringRedisService stringRedisService;
    @Autowired
    private MapRedisService mapRedisService;

    @RequestMapping(value = "/saveStringRedis", method = RequestMethod.POST)
    public SuccessRes saveStringRedis(String key, String value) {
        stringRedisService.setKey(key, value);
        return new SuccessRes("OK");
    }

    @RequestMapping(value = "/getStringRedis", method = RequestMethod.GET)
    public DataRes<String> getStringRedis(String key) {
        String value = stringRedisService.getValue(key);
        return new DataRes<String>(value);
    }

    @RequestMapping(value = "/delStringRedis", method = RequestMethod.GET)
    public SuccessRes delStringRedis(String key) {
        stringRedisService.removeKey(key);
        return new SuccessRes("OK");
    }

    @RequestMapping(value = "/saveMapRedis", method = RequestMethod.POST)
    public SuccessRes saveMapRedis(String key, User user) {
        mapRedisService.putAll(key, user);
        return new SuccessRes("OK");
    }

    @RequestMapping(value = "/getMapRedis", method = RequestMethod.GET)
    public DataRes<User> getMapRedis(String key) {
        User user = mapRedisService.getAll(key);
        return new DataRes<User>(user);
    }

    @RequestMapping(value = "/delMapRedis", method = RequestMethod.GET)
    public SuccessRes delMapRedis(String key) {
        mapRedisService.delAll(key);
        return new SuccessRes("OK");
    }
}
