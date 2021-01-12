package com.adweak.reference.feign.feignClients;

import com.adweak.reference.feign.entity.User;
import com.adweak.reference.feign.entity.res.DataRes;
import com.adweak.reference.feign.entity.res.SuccessRes;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author : xuzhaole
 * @date : 2020/12/23
 */

@FeignClient(name = "redis-demo")
@RequestMapping(value = "redis")
public interface RedisOneClient {

    @RequestMapping(value = "/saveStringRedis", method = RequestMethod.POST)
    SuccessRes saveStringRedis(@RequestParam("key") String key, @RequestParam("value") String value);

    @RequestMapping(value = "/getStringRedis", method = RequestMethod.GET)
    DataRes<String> getStringRedis(@RequestParam("key") String key);

    @RequestMapping(value = "/delStringRedis", method = RequestMethod.GET)
    SuccessRes delStringRedis(@RequestParam("key") String key);

    @RequestMapping(value = "/saveMapRedis", method = RequestMethod.POST)
    SuccessRes saveMapRedis(@RequestParam("key") String key, @RequestBody User user);

    @RequestMapping(value = "/getMapRedis", method = RequestMethod.GET)
    DataRes<User> getMapRedis(@RequestParam("key") String key);

    @RequestMapping(value = "/delMapRedis", method = RequestMethod.GET)
    SuccessRes delMapRedis(@RequestParam("key") String key);
}

