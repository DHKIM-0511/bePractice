package me.nrz.design_patterns._01_creational_patterns._03_abstract_factory._03_java;

import me.nrz.design_patterns._01_creational_patterns._02_factory_method._02_after.Ship;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanExample {

    public static void main(String[] args) {
        //config.xml 에  whiteship 으로 등록한 factory bean의 객체를 가져온다
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
//        Ship whiteship = applicationContext.getBean("whiteship", Ship.class);
//        System.out.println(whiteship.getName());


        //자바 config 로 가져올때는 factory bean 이 크게 의미는 없다
        //FactoryBeanConfig 로 ShipFactory 를 등록하는 경우에 factory 클래스, Ship 클래스 둘 다 가져올 수 있음
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
        ShipFactory factoryBean = applicationContext.getBean(ShipFactory.class);
        Ship bean = applicationContext.getBean(Ship.class);
        System.out.println(factoryBean);
        System.out.println(bean);
    }
}
