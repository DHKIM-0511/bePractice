package me.nrz.design_patterns._01_creational_patterns._01_singleton;

/**
 * 가장 간단하지만, 멀티스레드 환경에서 문제가 발생한다
 */
public class Settings {
    private static Settings instance;

    private Settings(){}

    public static Settings getInstance(){
        if(instance == null) instance = new Settings();
        return instance;
    }
}
