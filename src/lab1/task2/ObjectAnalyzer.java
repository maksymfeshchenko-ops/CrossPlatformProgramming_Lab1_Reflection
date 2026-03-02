package lab1.task2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ObjectAnalyzer {

    public static void analyze(Object obj) throws Exception {

        Class<?> clazz = obj.getClass();

        System.out.println("Real class: " + clazz.getName());

        // ---------- Fields ----------
        System.out.println("\nObject state:");

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true); // доступ до private
            System.out.println(
                    field.getType().getSimpleName()
                            + " "
                            + field.getName()
                            + " = "
                            + field.get(obj)
            );
        }

        // ---------- Public methods ----------
        System.out.println("\nPublic methods without parameters:");

        Method[] methods = clazz.getMethods();

        int counter = 1;

        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())
                    && method.getParameterCount() == 0) {

                System.out.println(counter + ") "
                        + method.getReturnType().getSimpleName()
                        + " "
                        + method.getName() + "()");

                counter++;
            }
        }

        // ---------- Choose method ----------
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nChoose method number: ");
        int choice = scanner.nextInt();

        counter = 1;

        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())
                    && method.getParameterCount() == 0) {

                if (counter == choice) {

                    Object result = method.invoke(obj);

                    System.out.println("Result: " + result);
                    return;
                }

                counter++;
            }
        }

        System.out.println("Invalid choice.");
    }
}
