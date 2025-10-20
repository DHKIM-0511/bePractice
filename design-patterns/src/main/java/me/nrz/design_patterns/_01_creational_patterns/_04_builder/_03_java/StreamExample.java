package me.nrz.design_patterns._01_creational_patterns._04_builder._03_java;

import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
//        Stream.Builder<String> stringStreamBuilder = Stream.builder();
//        Stream<String> names = stringStreamBuilder.add("nrz").add("whiteship").build();

        //Stream.builder()를 인라인으로 합치는경우 제네릭을 추가해야합칠 수 있음
        Stream<String> names = Stream.<String>builder().add("nrz").add("whiteship").build();
        names.forEach(System.out::println);
    }
}
