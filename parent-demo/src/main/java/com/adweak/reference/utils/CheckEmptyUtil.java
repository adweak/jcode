package com.adweak.reference.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author : xuzhaole
 * @date : 2020/12/22
 */

public class CheckEmptyUtil {
    public CheckEmptyUtil() {
    }

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        } else {
            if (object instanceof String) {
                String str = (String) object;
                if (str.trim().length() == 0) {
                    return true;
                }
            }

            if (object instanceof CharSequence) {
                CharSequence cs = (CharSequence) object;
                if (cs.length() == 0) {
                    return true;
                }

                if (cs.toString().trim().length() == 0) {
                    return true;
                }
            }

            if (object instanceof List) {
                List<?> list = (List) object;
                return list.isEmpty();
            } else {
                if (object.getClass().isArray()) {
                    Object[] array = (Object[]) object;
                    if (array.length == 0) {
                        return true;
                    }
                }

                if (object instanceof Map) {
                    Map<?, ?> map = (Map) object;
                    return map.isEmpty();
                } else if (object instanceof Set) {
                    Set<?> set = (Set) object;
                    return set.isEmpty();
                } else {
                    return false;
                }
            }
        }
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    public static boolean isOrEmpty(Object... objects) {
        if (objects != null && objects.length != 0) {
            Object[] var4 = objects;
            int var3 = objects.length;

            for (int var2 = 0; var2 < var3; ++var2) {
                Object object = var4[var2];
                if (isEmpty(object)) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }

    public static boolean isAndEmpty(Object... objects) {
        if (objects != null && objects.length != 0) {
            Object[] var4 = objects;
            int var3 = objects.length;

            for (int var2 = 0; var2 < var3; ++var2) {
                Object object = var4[var2];
                if (!isEmpty(object)) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }
}
