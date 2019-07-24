package interfaceTest;

/**
 * 一个接口可以有多个默认实现方法
 */
public interface Action {
    default void hello() {
        System.out.println("hello");
    }

    default void hello2() {
        System.out.println("hello2");
    }

    public String getSex();
}
