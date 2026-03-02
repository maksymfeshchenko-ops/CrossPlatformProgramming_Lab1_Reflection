package lab1.task1;

import java.lang.reflect.*;
import java.util.Arrays;

public class ClassAnalyzer {

    public static String analyze(String className) throws ClassNotFoundException {
        Class<?> clazz;

        switch (className) {
            case "int": clazz = int.class; break;
            case "double": clazz = double.class; break;
            case "boolean": clazz = boolean.class; break;
            default:
                clazz = Class.forName(className);
        }

        return analyze(clazz);
    }

    public static String analyze(Class<?> clazz) {

        StringBuilder sb = new StringBuilder();

        // Package
        if (clazz.getPackage() != null) {
            sb.append("package ").append(clazz.getPackage().getName()).append(";\n");
        }

        // Modifiers
        sb.append(Modifier.toString(clazz.getModifiers())).append(" ");

        if (clazz.isInterface())
            sb.append("interface ");
        else if (clazz.isEnum())
            sb.append("enum ");
        else
            sb.append("class ");

        sb.append(clazz.getSimpleName());

        // Superclass
        if (clazz.getSuperclass() != null) {
            sb.append(" extends ").append(clazz.getSuperclass().getSimpleName());
        }

        // Interfaces
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces.length > 0) {
            sb.append(" implements ");
            for (int i = 0; i < interfaces.length; i++) {
                sb.append(interfaces[i].getSimpleName());
                if (i < interfaces.length - 1)
                    sb.append(", ");
            }
        }

        sb.append(" {\n");

        // Fields
        sb.append("\n // Fields\n");
        for (Field field : clazz.getDeclaredFields()) {
            sb.append("  ")
                    .append(Modifier.toString(field.getModifiers()))
                    .append(" ")
                    .append(field.getType().getSimpleName())
                    .append(" ")
                    .append(field.getName())
                    .append(";\n");
        }

        // Constructors
        sb.append("\n // Constructors\n");
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            sb.append("  ")
                    .append(Modifier.toString(constructor.getModifiers()))
                    .append(" ")
                    .append(clazz.getSimpleName())
                    .append("(");

            Class<?>[] params = constructor.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                sb.append(params[i].getSimpleName()).append(" arg").append(i);
                if (i < params.length - 1)
                    sb.append(", ");
            }
            sb.append(");\n");
        }

        // Methods
        sb.append("\n // Methods\n");
        for (Method method : clazz.getDeclaredMethods()) {
            sb.append("  ")
                    .append(Modifier.toString(method.getModifiers()))
                    .append(" ")
                    .append(method.getReturnType().getSimpleName())
                    .append(" ")
                    .append(method.getName())
                    .append("(");

            Class<?>[] params = method.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                sb.append(params[i].getSimpleName()).append(" arg").append(i);
                if (i < params.length - 1)
                    sb.append(", ");
            }
            sb.append(");\n");
        }

        sb.append("}");
        return sb.toString();
    }
}
