package me.nrz.design_patterns._01_creational_patterns._01_singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * reflection 으로 싱글톤을 깨기
 */
public class App {
    public static void main(String[] args)
        throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Settings4 settings = Settings4.getInstance();

        //new 를 사용하는것과 같다
        Constructor<Settings4> constructor = Settings4.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Settings4 reflectionSettings = constructor.newInstance();

        System.out.println(settings == reflectionSettings);
    }
}
