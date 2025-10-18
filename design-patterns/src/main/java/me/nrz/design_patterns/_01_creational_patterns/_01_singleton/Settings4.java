package me.nrz.design_patterns._01_creational_patterns._01_singleton;

/**
 * 권장1. static inner class 사용
 * 스레드 세이프 + 레이지 로딩 가능
 */
public class Settings4 {
    private Settings4(){}

    private static class SettingsHolder{
        private static final Settings4 INSTANCE = new Settings4();
    }

    public static Settings4 getInstance(){
        return SettingsHolder.INSTANCE;
    }
}
