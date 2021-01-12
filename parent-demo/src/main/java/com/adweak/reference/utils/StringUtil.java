package com.adweak.reference.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
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

    public StringUtil() {
    }

    public static String getArrayString(Object[] args) {
        try {
            if (args != null && args.length != 0) {
                StringBuilder sb = new StringBuilder("{");
                Object[] var5 = args;
                int var4 = args.length;

                for (int var3 = 0; var3 < var4; ++var3) {
                    Object arg = var5[var3];
                    if (CheckEmptyUtil.isEmpty(arg)) {
                        sb.append(",");
                    } else {
                        String str = null;
                        if (!(arg instanceof String) && !(arg instanceof Integer) && !(arg instanceof Long) && !(arg instanceof Double) && !(arg instanceof Float)) {
                            if (arg instanceof HttpServletRequest) {
                                HttpServletRequest request = (HttpServletRequest) arg;
                                StringBuilder newSb = new StringBuilder();
                                newSb.append("{");
                                Map<String, String[]> params = request.getParameterMap();
                                if (CheckEmptyUtil.isNotEmpty(params)) {
                                    Set<String> keys = params.keySet();
                                    Iterator var12 = keys.iterator();

                                    while (var12.hasNext()) {
                                        String key = (String) var12.next();
                                        newSb.append(key).append("=").append(arrayToString((String[]) params.get(key))).append(",");
                                    }

                                    return newSb.substring(0, newSb.length() - 1) + "}";
                                }
                            } else {
                                str = getJsonString(arg);
                            }
                        } else {
                            str = arg.toString();
                        }

                        sb.append(str + ",");
                    }
                }

                String result = "";
                if (sb.length() > 1) {
                    result = sb.substring(0, sb.length() - 1);
                } else {
                    result = sb.toString();
                }

                result = result + "}";
                return result;
            } else {
                return "";
            }
        } catch (Exception var13) {
            logger.debug("error when format args", var13);
            return null;
        }
    }

    private static String arrayToString(String[] array) {
        if (CheckEmptyUtil.isEmpty(array)) {
            return null;
        } else if (array.length == 1) {
            return array[0];
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            String[] var5 = array;
            int var4 = array.length;

            for (int var3 = 0; var3 < var4; ++var3) {
                String str = var5[var3];
                sb.append(str).append(",");
            }

            return sb.substring(0, sb.length() - 1) + "]";
        }
    }

    public static String getJsonString(Object value) {
        if (CheckEmptyUtil.isEmpty(value)) {
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();

            try {
                return mapper.writeValueAsString(value);
            } catch (JsonProcessingException var3) {
                logger.debug("error when generate json string" + value, var3);
                return null;
            }
        }
    }

    public static Integer[] parseIntegerArray(String str) {
        String[] strs = str.split(",");
        Integer[] ints = new Integer[strs.length];

        for (int i = 0; i < ints.length; ++i) {
            ints[i] = Integer.parseInt(strs[i]);
        }

        return ints;
    }

    public static Long[] parseLongArray(String str) {
        String[] strs = str.split(",");
        Long[] longs = new Long[strs.length];

        for (int i = 0; i < longs.length; ++i) {
            longs[i] = Long.parseLong(strs[i]);
        }

        return longs;
    }

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
