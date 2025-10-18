package me.nrz.design_patterns._01_creational_patterns._01_singleton;

/**
 * Runtime: 자바 app 이 실행되고 있는 환경 및 문맥 정보
 */
public class RuntimeExample {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.freeMemory());
    }
}
