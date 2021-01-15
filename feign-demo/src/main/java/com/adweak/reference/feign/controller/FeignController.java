package com.adweak.reference.feign.controller;

import com.adweak.reference.feign.entity.User;
import com.adweak.reference.feign.entity.res.DataRes;
import com.adweak.reference.feign.entity.res.ErrorRes;
import com.adweak.reference.feign.entity.res.SuccessRes;
import com.adweak.reference.feign.feignClients.RedisOneClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.adweak.reference.feign.constants.ErrorCodes.CLIENT_ERROR;

/**
 * @author : xuzhaole
 * @date : 2020/12/23
 */

@RestController
//@RequestMapping(value = "feign")
@Api(value = "Feign Demo 接口案例")
public class FeignController {

    @Autowired
    private RedisOneClient client;

    @ApiOperation(value = "feign -> 保存StringRedis")
    @RequestMapping(value = "/saveStringRedis", method = RequestMethod.POST)
    public Object saveStringRedis(String key, String value) {
        SuccessRes successRes = client.saveStringRedis(key, value);
        if (successRes.getResultCode() == 0) {
            return new SuccessRes("OK");
        } else {
            return new ErrorRes(CLIENT_ERROR.value(), CLIENT_ERROR.desc());
        }
    }

    @ApiOperation(value = "feign -> 获取StringRedis")
    @RequestMapping(value = "/getStringRedis", method = RequestMethod.GET)
    public Object getStringRedis(String key) {
        DataRes<String> dataRes = client.getStringRedis(key);
        if (dataRes.getResultCode() == 0) {
            return new DataRes<String>(dataRes.getData());
        } else {
            return new ErrorRes(CLIENT_ERROR.value(), CLIENT_ERROR.desc());
        }
    }

    @ApiOperation(value = "feign -> 删除StringRedis")
    @RequestMapping(value = "/delStringRedis", method = RequestMethod.GET)
    public Object delStringRedis(String key) {
        SuccessRes successRes = client.delStringRedis(key);
        if (successRes.getResultCode() == 0) {
            return new SuccessRes("OK");
        } else {
            return new ErrorRes(CLIENT_ERROR.value(), CLIENT_ERROR.desc());
        }
    }

    @ApiOperation(value = "feign -> 保存MapRedis")
    @RequestMapping(value = "/saveMapRedis", method = RequestMethod.POST)
    public Object saveMapRedis(String key, User user) {
        SuccessRes successRes = client.saveMapRedis(key, user);
        if (successRes.getResultCode() == 0) {
            return new SuccessRes("OK");
        } else {
            return new ErrorRes(CLIENT_ERROR.value(), CLIENT_ERROR.desc());
        }
    }

    @ApiOperation(value = "feign -> 获取MapRedis")
    @RequestMapping(value = "/getMapRedis", method = RequestMethod.GET)
    public Object getMapRedis(String key) {
        DataRes<User> dataRes = client.getMapRedis(key);
        if (dataRes.getResultCode() == 0) {
            return new DataRes<User>(dataRes.getData());
        } else {
            return new ErrorRes(CLIENT_ERROR.value(), CLIENT_ERROR.desc());
        }
    }

    @ApiOperation(value = "feign -> 删除MapRedis")
    @RequestMapping(value = "/delMapRedis", method = RequestMethod.GET)
    public Object delMapRedis(String key) {
        SuccessRes successRes = client.delMapRedis(key);
        if (successRes.getResultCode() == 0) {
            return new SuccessRes("OK");
        } else {
            return new ErrorRes(CLIENT_ERROR.value(), CLIENT_ERROR.desc());
        }
    }
}
