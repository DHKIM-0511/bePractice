package me.nrz.design_patterns._01_creational_patterns._01_singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * enum 은 직렬화 역직렬화를 거쳐도 같은 객체 상태가 유지됨
 */
public class App3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Settings6 settings = Settings6.INSTANCE;
        Settings6 newSettings;

        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(settings);
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            newSettings = (Settings6) in.readObject();
        }
        System.out.println(settings == newSettings);
    }
}
