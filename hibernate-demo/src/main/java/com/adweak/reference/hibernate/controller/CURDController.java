package com.adweak.reference.hibernate.controller;

import com.adweak.reference.hibernate.entity.DataRes;
import com.adweak.reference.hibernate.entity.DemoException;
import com.adweak.reference.hibernate.service.BaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import java.io.Serializable;

import static com.adweak.reference.hibernate.constants.ErrorCodes.PARAM_ERROR;
import static utils.CheckEmptyUtil.isEmpty;

public abstract class CURDController<T> {

	protected abstract BaseService getService();

    @ApiOperation(value = "获取")
    @RequestMapping(value = "/getById", method = {RequestMethod.GET})
    public DataRes<T> getById(Integer id, @ApiIgnore T t) {
        if (isEmpty(id)) {
            throw new DemoException(PARAM_ERROR.value(), PARAM_ERROR.desc("id"));
        }
        Object result = getService().getById(t.getClass(), (Serializable) id);
        return new DataRes(result);
    }

	@ApiOperation(value = "插入")
    @ApiIgnore
    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
	public DataRes<Integer> insert(@RequestBody T param) {
        Serializable serializable = getService().insert(param);
        return new DataRes<>((Integer) serializable);
	}

    @ApiOperation(value = "更新")
    @ApiIgnore
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public DataRes update(@RequestBody T param) {
        getService().update(param);
        return new DataRes();
    }

	@ApiOperation(value = "删除")
    @ApiIgnore
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
	public DataRes delete(Integer id,@ApiIgnore T t) {
		if (isEmpty(id)) {
			throw new DemoException(PARAM_ERROR.value(), PARAM_ERROR.desc("id"));
		}
		Object completeObject = getService().getById(t.getClass(), (Serializable)id);
		getService().delete(completeObject);
		return new DataRes();
	}

}
