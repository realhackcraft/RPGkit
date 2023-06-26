package utils;

import java.lang.reflect.Field;

public class ObjectUtils {
    public <T> T findObjectWithFieldValue(Iterable<T> iterable, String fieldName, Object fieldValue) {
        for (T obj : iterable) {
            Field field;
            try {
                field = obj.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value != null && value.equals(fieldValue)) {
                    return obj;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
