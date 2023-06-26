package utils;

import java.lang.reflect.Field;
import java.util.Optional;

public class ObjectUtils {
    public <T> Optional<T> findObjectWithFieldValue(Iterable<T> iterable, String fieldName, Object fieldValue) {
        for (T obj : iterable) {
            Field field;
            try {
                field = obj.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value != null && value.equals(fieldValue)) {
                    return Optional.of(obj);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }
}
