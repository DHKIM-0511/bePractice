package me.nrz.design_patterns._01_creational_patterns._01_singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 리플렉션으로 생성을 시도해도, IllegalArgumentException 이 발생하며 막힌다
 */
public class App2 {
    public static void main(String[] args)
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Settings6 settings = Settings6.INSTANCE;

        Settings6 newSettings = null;
        Constructor<?>[] constructors = Settings6.class.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            newSettings = (Settings6) constructor.newInstance("INSTANCE");
        }

        System.out.println(settings == newSettings);
    }
}
