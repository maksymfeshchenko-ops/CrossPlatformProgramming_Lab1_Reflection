package lab1.task5;

import java.lang.reflect.Proxy;

public class MainTask5 {

    public static void main(String[] args) {

        Evaluatable original = new ExpFunction(2.5);

        Evaluatable proxy = (Evaluatable) Proxy.newProxyInstance(
                original.getClass().getClassLoader(),
                original.getClass().getInterfaces(),
                new ProfilingHandler(original)
        );

        System.out.println("Result: " + proxy.evalf(1.0));
    }
}
