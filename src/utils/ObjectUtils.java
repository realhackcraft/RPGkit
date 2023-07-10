package utils;

import java.lang.reflect.Field;

/**
 * Utility methods for working with objects.
 */

public class ObjectUtils {
    /**
     * Searches for an object of a generic type T with the specified field name and value in an iterable.
     *
     * @param iterable   The iterable to search for the object.
     * @param fieldName  The name of the field to search for in each object.
     * @param fieldValue The desired value to search for in each field.
     * @param <T>        The generic type of the object in the iterable.
     * @return The first object found with the specified field name and value, or null if none is found.
     */
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
