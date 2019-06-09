package others;

import java.net.URLClassLoader;

public class TestClassLoader {
    static URLClassLoader urlClassLoader;

    public static void main(String[] args) {
//        System.out.println(urlClassLoader.getParent());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(URLClassLoader.getSystemClassLoader());
        System.out.println(URLClassLoader.getSystemClassLoader().getParent());
    }
}
