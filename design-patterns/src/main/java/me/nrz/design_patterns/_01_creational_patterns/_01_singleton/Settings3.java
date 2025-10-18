package me.nrz.design_patterns._01_creational_patterns._01_singleton;

/**
 * double check locking 사용하기.
 * A 스레드가 첫 if 문을 통과하고 바로 B 스레드도 통과한 경우, synchronized 블럭에서 B는 대기하다가,
 * A 스레드가 객체를 만들고 난뒤 B 스레드가 synchronized 블럭에 들어가 객체 검사를 하고 그대로 리턴한다.
 *
 * 너무 복잡함.. + 여기서 volatile 키워드를 쓰는이유눈 자바 1.4 이하의 메모리 동작 구조를 잘 알아야한다 -> 너무 헤비하다
 */
public class Settings3 {
    private static volatile Settings3 instance;

    private Settings3(){}

    public static Settings3 getInstance(){
        if(instance == null){
            synchronized (Settings3.class){
                if(instance == null){
                    instance = new Settings3();
                }
            }
        }
        return instance;
    }
}
