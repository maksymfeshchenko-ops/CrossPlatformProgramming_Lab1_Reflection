package lab1.task5;

import java.lang.reflect.*;

public class ProfilingHandler implements InvocationHandler {

    private Object target;

    public ProfilingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy,
                         Method method,
                         Object[] args) throws Throwable {

        long start = System.nanoTime();

        Object result = method.invoke(target, args);

        long end = System.nanoTime();

        System.out.println(method.getName()
                + " took "
                + (end - start)
                + " ns");

        return result;
    }
}
