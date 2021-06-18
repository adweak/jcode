package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author : xuzhaole
 * @date : 2021/6/17
 */

public class SerializationUtil {
    public SerializationUtil() {
    }

    public static byte[] serialize(Object object) {
        try {
            if (object == null) {
                return null;
            } else {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(object);
                return baos.toByteArray();
            }
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }

    public static Object deserialize(byte[] data) {
        try {
            if (data != null && data.length != 0) {
                ByteArrayInputStream bais = new ByteArrayInputStream(data);
                ObjectInputStream ois = new ObjectInputStream(bais);
                return ois.readObject();
            } else {
                return null;
            }
        } catch (Exception var3) {
            return new RuntimeException(var3);
        }
    }

    public static <T> T deepClone(T t) {
        byte[] objectBytes = serialize(t);
        T result = (T) deserialize(objectBytes);
        return result;
    }
}
