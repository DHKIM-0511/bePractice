package me.nrz.design_patterns._01_creational_patterns._01_singleton;

import java.io.Serializable;

/**
 * 권장1. static inner class 사용
 * 스레드 세이프 + 레이지 로딩 가능
 */
public class Settings5 implements Serializable {
    private Settings5(){}

    private static class SettingsHolder{
        private static final Settings5 INSTANCE = new Settings5();
    }

    public static Settings5 getInstance(){
        return SettingsHolder.INSTANCE;
    }

    protected Object readResolve(){
        return getInstance();
    }
}
