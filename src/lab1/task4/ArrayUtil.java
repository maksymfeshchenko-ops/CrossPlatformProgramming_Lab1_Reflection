package lab1.task4;

import java.lang.reflect.Array;

public class ArrayUtil {

    public static Object create1DArray(Class<?> type, int size) {
        return Array.newInstance(type, size);
    }

    public static Object create2DArray(Class<?> type, int rows, int cols) {
        return Array.newInstance(type, rows, cols);
    }

    public static Object resize1DArray(Object array, int newSize) {

        int oldSize = Array.getLength(array);
        Class<?> type = array.getClass().getComponentType();

        Object newArray = Array.newInstance(type, newSize);

        System.arraycopy(array, 0, newArray, 0,
                Math.min(oldSize, newSize));

        return newArray;
    }

    public static String arrayToString(Object array) {

        if (!array.getClass().isArray())
            return "Not an array";

        StringBuilder sb = new StringBuilder();

        int length = Array.getLength(array);
        sb.append("{");

        for (int i = 0; i < length; i++) {

            Object element = Array.get(array, i);

            if (element != null && element.getClass().isArray()) {
                sb.append(arrayToString(element));
            } else {
                sb.append(element);
            }

            if (i < length - 1)
                sb.append(", ");
        }

        sb.append("}");

        return sb.toString();
    }
}
