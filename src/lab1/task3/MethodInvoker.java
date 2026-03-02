package lab1.task3;

import java.lang.reflect.Method;

public class MethodInvoker {

    public static Object invoke(Object obj,
                                String methodName,
                                Object... params) throws Exception {

        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {

            if (method.getName().equals(methodName)
                    && method.getParameterCount() == params.length) {

                return method.invoke(obj, params);
            }
        }

        throw new FunctionNotFoundException(
                "Method not found: " + methodName
        );
    }
}
