package com.adweak.reference.hibernate.controller;

import com.adweak.reference.hibernate.domain.Language;
import com.adweak.reference.hibernate.domain.LanguageMeta;
import com.adweak.reference.hibernate.entity.DataRes;
import com.adweak.reference.hibernate.entity.PaginationModel;
import com.adweak.reference.hibernate.service.BaseService;
import com.adweak.reference.hibernate.service.LanguageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : xuzhaole
 * @date : 2021/6/17
 */

@RestController
@Api(tags = "1-语言接口")
public class LanguageController extends CURDController<Language>{

    @Override
    protected BaseService getService() {
        return service;
    }

    @Autowired
    private LanguageService service;

    @ApiOperation(value = "获取配置项(分页)")
    @RequestMapping(value = "query", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "languageId", value = "语言Id", paramType = "query"),
            @ApiImplicitParam(name = "isoCode", value = "ISO编码", paramType = "query"),
            @ApiImplicitParam(name = "nativeName", value = "本语言名称", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态", paramType = "query"),
            @ApiImplicitParam(name = "isDefault", value = "是否是预置数据", paramType = "query")
    })
    public DataRes<PaginationModel<Language>> getLanguage(Integer languageId, String isoCode, String nativeName, Integer status, Integer isDefault,
                                                            @RequestParam(required = false, defaultValue = "0")Integer start,
                                                            @RequestParam(required = false, defaultValue = "20")Integer limit) {
        return service.getLanguage(languageId, isoCode, nativeName, status, isDefault, start, limit);
    }

    @ApiOperation(value = "获取配置项(字典)")
    @RequestMapping(value = "getLanguageDic", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "isoCode", value = "ISO编码", paramType = "query"),
            @ApiImplicitParam(name = "nativeName", value = "本语言名称", paramType = "query"),
            @ApiImplicitParam(name = "languageId", value = "语言Id", paramType = "query", example = "0")
    })
    public DataRes<List<Language>> getLanguageDic(String isoCode, String nativeName, Integer languageId) {
        return service.getLanguageDic(isoCode, nativeName, languageId);
    }

    @ApiOperation(value = "获取语言Meta(字典)")
    @RequestMapping(value = "meta/getLanguageMetaDic", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "languageId", value = "语言Id", paramType = "query"),
            @ApiImplicitParam(name = "languageName", value = "语言名称", paramType = "query"),
            @ApiImplicitParam(name = "languageId2", value = "语言Id的语言Id", paramType = "query", example = "0")
    })
    public DataRes<List<LanguageMeta>> getLanguageMetaDic(Integer languageId, String languageName, Integer languageId2) {
        return service.getLanguageMetaDic(languageId, languageName, languageId2);
    }
}
