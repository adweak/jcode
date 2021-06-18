package com.adweak.reference.hibernate.dao;

import com.adweak.reference.hibernate.entity.PaginationModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import utils.SerializationUtil;

import java.io.Serializable;
import java.util.List;

import static utils.CheckEmptyUtil.isNotEmpty;
import static utils.CheckEmptyUtil.isOrEmpty;

@Repository
@SuppressWarnings({ "rawtypes", "unchecked" })
@Primary
public class HibernateBaseDao {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier(value = "hibernateDemoSessionFactory")
    protected SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Criteria getCriteria(Class c) {
        return getSession().createCriteria(c);
    }

    public int getTotal(Criteria criteria) {
        criteria.setProjection(Projections.rowCount());
        Long total = (Long) criteria.uniqueResult();
        if (total == null) {
            return 0;
        }
        return Integer.parseInt(total + "");
    }

    public int getTotal(DetachedCriteria criteria) {
        Criteria newCriteria = criteria.getExecutableCriteria(getSession());
        return getTotal(newCriteria);
    }

    public <T> List<T> getData(Criteria criteria) {
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List result = criteria.list();
        return result;
    }

    public <T> List<T> getData(DetachedCriteria detachedCriteria) {
        Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    /**
     * 根据 detachedCriteria 进行分页查询
     * @param detachedCriteria
     * @param start
     * @param limit
     * @param notSerializedCriterion　
     *         方法内时通过序列化的方式进行深度复制，以实现总数和分页数据的查询的，
     *         但是如果DetachedCriteria中含有不能被序列化的Criterion（比如
     *         Restrictions.sqlRestriction生成的查询条件就不能被序列化因为
     *         其内部用到的ValueHolder没有实现Serializable接口)则会导致复制
     *         失败，因此这里将不能序列化的部分作为单独的参数。
     * @return
     */
    public <T> PaginationModel<T> getPaginationData(
            DetachedCriteria detachedCriteria,
            Integer start,
            Integer limit,
            Criterion... notSerializedCriterion) {
        DetachedCriteria taotalDetachedCriteria = SerializationUtil.deepClone(detachedCriteria);
        Criteria criteria = detachedCriteria.getExecutableCriteria(getSession());
        Criteria totalCriteria = taotalDetachedCriteria.getExecutableCriteria(getSession());
        if (isNotEmpty(notSerializedCriterion)) {
            for (Criterion criterion : notSerializedCriterion) {
                criteria.add(criterion);
                totalCriteria.add(criterion);
            }
        }
        int innerStart = 0;
        int innerLimit = 0;
        if (!isOrEmpty(start, limit)) {
            criteria.setFirstResult(start);
            criteria.setMaxResults(limit);
            innerStart = start;
            innerLimit = limit;
        }
        int total = getTotal(totalCriteria);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List rows = criteria.list();
        return new PaginationModel<T>(rows, total, innerStart, innerLimit);
    }

    public Serializable insert(Object entity) {
        Serializable id = getSession().save(entity);
        return id;
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }

    public void update(Object entity) {
        getSession().update(entity);
    }

    public <T> T getById(Class<T> c, Serializable id) {
        return (T) getSession().get(c, id);
    }

    public void saveOrUpdate(Object entity){
        getSession().saveOrUpdate(entity);
    }

    public void flushSession(){
        getSession().flush();
    }

    public void clearSession(){
        getSession().clear();
    }
}
