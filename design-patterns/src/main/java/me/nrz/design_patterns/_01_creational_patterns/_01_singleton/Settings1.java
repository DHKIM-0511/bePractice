package me.nrz.design_patterns._01_creational_patterns._01_singleton;

/**
 * 멀티스레드에서 안전하지만, 동기화로 성능에 악영향이 생길 수 있음
 */
public class Settings1 {
    private static Settings1 instance;

    private Settings1(){}

    public static synchronized Settings1 getInstance(){
        if(instance == null) instance = new Settings1();
        return instance;
    }
}
