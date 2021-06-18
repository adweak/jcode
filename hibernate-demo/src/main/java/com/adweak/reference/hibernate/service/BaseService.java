package com.adweak.reference.hibernate.service;

import com.adweak.reference.hibernate.dao.HibernateBaseDao;
import com.adweak.reference.hibernate.entity.PaginationModel;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

import static utils.CheckEmptyUtil.isEmpty;
import static utils.CheckEmptyUtil.isNotEmpty;

@Service
@Transactional
public class BaseService {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected HibernateBaseDao baseDao;

    public Serializable insert(Object entity) {
        return baseDao.insert(entity);
    }

    public void delete(Object entity) {
        baseDao.delete(entity);
    }

    @SuppressWarnings("rawtypes")
    public void delete(DetachedCriteria criteria) {
        List list = getData(criteria);
        if (isNotEmpty(list)) {
            for (Object object : list) {
                baseDao.delete(object);                
            }
        }
    }

    public void update(Object entity) {
        baseDao.update(entity);
    }

    public int getTotal(DetachedCriteria criteria) {
        return baseDao.getTotal(criteria);
    }

    public <T> List<T> getData(DetachedCriteria criteria) {
        return baseDao.getData(criteria);
    }

    public <T> PaginationModel<T> getPaginationData(
            DetachedCriteria criteria,
            Integer start, 
            Integer limit, 
            Criterion...notSerializedCriterion) {
        return baseDao.getPaginationData(criteria, start, limit,notSerializedCriterion);
    }

    public <T> T getById(Class<T> c, Serializable id) {
        return baseDao.getById(c, id);
    }

    /**
     * 获取一个参数的like形式，即在前后加上%
     * 如有必要，将添加对参数内特殊字符的转义功能
     * 
     * Hibernate Criteria的like方法中有MatchMode参数，
     * 带上这个参数可以取代本方法
     * @param param
     * @return
     */
    protected String getLikeParameter(String param) {
        return "%" + param + "%";
    }

    protected <T> DetachedCriteria getCriteria(Class<T> c, String...alias) {
        if (isEmpty(alias)) {
            return DetachedCriteria.forClass(c);
        }else{
            return DetachedCriteria.forClass(c, alias[0]);
        }
        
    }

    public void saveOrUpdate(Object entity){
        baseDao.saveOrUpdate(entity);
    }
    public void flush(){
        baseDao.flushSession();
    }
    public void clear(){
        baseDao.clearSession();
    }
}
