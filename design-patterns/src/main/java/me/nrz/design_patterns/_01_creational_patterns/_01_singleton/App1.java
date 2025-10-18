package me.nrz.design_patterns._01_creational_patterns._01_singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 직렬화 역직렬화로 싱글톤 깨기
 */
public class App1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Settings5 settings = Settings5.getInstance();
        Settings5 newSettings;

        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(settings);
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            newSettings = (Settings5) in.readObject();
        }
        System.out.println(settings == newSettings);
    }
}
