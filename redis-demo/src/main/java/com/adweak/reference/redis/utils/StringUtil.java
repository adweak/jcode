package com.adweak.reference.redis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author : xuzhaole
 * @date : 2020/12/22
 */

public class StringUtil {
    private static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    public static Map<String,Object> entityToMap(Object object){
        Map<String,Object> map = null;
        try {
            map = new HashMap<String, Object>();

            BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (key.compareToIgnoreCase("class") == 0) {
                    continue;
                }
                Method getter = property.getReadMethod();
                Object value = getter!=null ? getter.invoke(object) : null;
                map.put(key, value);
            }
            //key 可能会把自己的class 和hashcode编进去，直接去掉
            map.remove("class");

        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<String,Object>();
        }
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String key = it.next();
            if (map.get(key)==null || map.get(key)==""){
                map.remove(key);
                set = map.keySet();
                it = set.iterator();
            }
        }
        return map;
    }

    public static <T> T mapToEntity(Map<String, Object> map, Class<T> entity) {
        T t = null;
        try {
            t = entity.newInstance();
            for (Field field : entity.getDeclaredFields()) {
                if (map.containsKey(field.getName())) {
                    boolean flag = field.isAccessible();
                    field.setAccessible(true);
                    Object object = map.get(field.getName());
                    if (object != null && field.getType().isAssignableFrom(object.getClass())) {
                        field.set(t, object);
                    }
                    field.setAccessible(flag);
                }
            }
            return t;
        } catch (Exception e) {
            logger.error("mapToEntity Error :{}", e);
        }
        return t;
    }
}
