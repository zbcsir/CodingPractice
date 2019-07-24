package designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 单例模式的几种实现方式
 * 1 饿汉模式
 */
public final class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }
}

/**
 * 2 懒汉模式 + Synchronized + Double-Check
 */
final class Singleton2 {
    private volatile static Singleton2 instance = null;
    // 类属性
    public List<String> list;
    private Singleton2() {
        // 构造函数需要实例化其属性
        list = new ArrayList<>();
    }
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

/**
 * 懒汉模式 + 内部类
 */
final class Singleton3 {
    public List<String> list;
    private Singleton3() {
        list = new ArrayList<>();
    }
    private static class InnerSingleton {
        private static Singleton3 instance = new Singleton3();
    }
    public static Singleton3 getInstance() {
        return InnerSingleton.instance;
    }
}

/**
 * 基于枚举实现单例模式
 */
enum Singleton4 {
    /**
     * 对象实例
     */
    INSTANCE;
    public static Singleton4 getInstance() {
        return INSTANCE;
    }
}

/**
 * 单例测试类
 */
class SingletonTest {
    public static void main(String[] args) {
        System.out.println("===========Singleton===========");
        Singleton s11 = Singleton.getInstance();
        Singleton s12 = Singleton.getInstance();
        System.out.println(s11 == s12);
        System.out.println("===========Singleton2===========");
        Singleton2 s21 = Singleton2.getInstance();
        Singleton2 s22 = Singleton2.getInstance();
        System.out.println(s21 == s22);
        System.out.println("===========Singleton3===========");
        Singleton3 s31 = Singleton3.getInstance();
        Singleton3 s32 = Singleton3.getInstance();
        System.out.println(s31 == s32);
        System.out.println("===========Singleton4===========");
        Singleton4 s41 = Singleton4.getInstance();
        Singleton4 s42 = Singleton4.getInstance();
        System.out.println(s41 == s42);
    }
}
