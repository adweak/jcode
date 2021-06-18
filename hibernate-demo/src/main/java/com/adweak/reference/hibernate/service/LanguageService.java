package com.adweak.reference.hibernate.service;

import com.adweak.reference.hibernate.domain.Language;
import com.adweak.reference.hibernate.domain.LanguageMeta;
import com.adweak.reference.hibernate.entity.DataRes;
import com.adweak.reference.hibernate.entity.DemoException;
import com.adweak.reference.hibernate.entity.PaginationModel;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.adweak.reference.hibernate.constants.ErrorCodes.PARAM_EMPTY;
import static utils.CheckEmptyUtil.isNotEmpty;

/**
 * @author : xuzhaole
 * @date : 2021/6/17
 */

@Service
public class LanguageService extends BaseService {


    public DataRes<PaginationModel<Language>> getLanguage(Integer languageId, String isoCode, String nativeName,
                                                          Integer status, Integer isDefault, Integer start, Integer limit) {
        DetachedCriteria dc = getCriteria(Language.class);
        if (isNotEmpty(languageId)) {
            dc.add(Restrictions.eq("languageId", languageId));
        }
        if (isNotEmpty(isoCode)) {
            dc.add(Restrictions.like("isoCode", isoCode, MatchMode.ANYWHERE));
        }
        if (isNotEmpty(nativeName)) {
            dc.add(Restrictions.like("nativeName", nativeName, MatchMode.ANYWHERE));
        }
        if (isNotEmpty(status)) {
            dc.add(Restrictions.eq("status", status));
        }
        if (isNotEmpty(isDefault)) {
            dc.add(Restrictions.eq("isDefault", isDefault));
        }
        PaginationModel<Language> data = getPaginationData(dc, start, limit);
        return new DataRes<>(data);
    }

    public DataRes<List<Language>> getLanguageDic(String isoCode, String nativeName, Integer languageId) {
        DetachedCriteria dc = getCriteria(Language.class, "l");
        dc.createAlias("l.metaList", "m", JoinType.LEFT_OUTER_JOIN);
        if (isNotEmpty(isoCode)) {
            dc.add(Restrictions.eq("isoCode", isoCode));
        }
        if (isNotEmpty(nativeName)) {
            dc.add(Restrictions.eq("nativeName", nativeName));
        }
        if (isNotEmpty(languageId)) {
            dc.add(Restrictions.eq("m.languageId2", languageId));
        } else {
            throw new DemoException(PARAM_EMPTY.value(), PARAM_EMPTY.desc("languageId"));
        }
        List<Language> data = getData(dc);
        return new DataRes<>(data);
    }

    public DataRes<List<LanguageMeta>> getLanguageMetaDic(Integer languageId, String languageName, Integer languageId2) {
        DetachedCriteria dc = getCriteria(LanguageMeta.class);
        if (isNotEmpty(languageId)) {
            dc.add(Restrictions.eq("languageId", languageId));
        }
        if (isNotEmpty(languageName)) {
            dc.add(Restrictions.like("languageName", languageName, MatchMode.ANYWHERE));
        }
        if (isNotEmpty(languageId2)) {
            dc.add(Restrictions.eq("languageId2", languageId2));
        }
        List<LanguageMeta> data = getData(dc);
        return new DataRes<>(data);
    }
}
