package interfaceTest;

/**
 * һ���ӿڿ����ж��Ĭ��ʵ�ַ���
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
