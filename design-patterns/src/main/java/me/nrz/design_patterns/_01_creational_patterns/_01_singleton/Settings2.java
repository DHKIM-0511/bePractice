package me.nrz.design_patterns._01_creational_patterns._01_singleton;

/**
 * eager initialization 사용, 객체 생성 비용이 비싸지 않은 경우
 */
public class Settings2 {
    private static final Settings2 INSTANCE = new Settings2();

    private Settings2(){}

    public static Settings2 getInstance(){
        return INSTANCE;
    }
}
