package homework7;

import homework7.annotations.AfterSuite;
import homework7.annotations.BeforeSuite;
import homework7.annotations.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.TreeMap;

public class Tester {
    public static void start(Class<?> testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        Method before = null;
        Method after = null;
        TreeMap<Integer, HashSet<Method>> tests = new TreeMap<>();
        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (before == null) before = method;
                else throw new RuntimeException("There is more than 1 @BeforeSuite method");
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                if (after == null) after = method;
                else throw new RuntimeException("There is more than 1 @AfterSuite method");
            }
            if (method.getAnnotation(MyTest.class) != null) {
                int priority = method.getAnnotation(MyTest.class).value();
                tests.putIfAbsent(priority, new HashSet<>());
                tests.get(priority).add(method);
            }
        }
        try {
            Object testObject = testClass
                    .getConstructor()
                    .newInstance();
            if (before != null) {
                before.invoke(testObject);
            }
            for (HashSet<Method> methodsToTest : tests.values()) {
                for (Method method : methodsToTest) {
                    method.invoke(testObject);
                }
            }
            if (after != null) {
                after.invoke(testObject);
            }
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
