package designpattern.factory;

import java.lang.reflect.Constructor;

@SuppressWarnings("unchecked")
public class SingletonFactory {
    private static Singleton singleton = null;
    static {
        try {
            Class c = Class.forName(Singleton.class.getName());
            Constructor constructor = c.getDeclaredConstructor();
            constructor.setAccessible(true);
            singleton = (Singleton) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}

class TestReflect {
    public static void main(String[] args) {
        Singleton singleton1 = SingletonFactory.getSingleton();
        Singleton singleton2 = SingletonFactory.getSingleton();
        System.out.println(singleton1 == singleton2);
    }
}