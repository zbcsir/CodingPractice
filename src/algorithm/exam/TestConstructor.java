package algorithm.exam;

/**
 * ���캯������
 * �������вι��캯��ʱ��Java����������Ĭ�ϵ���͹��캯������14�еĴ��뽫���벻ͨ��
 */
public class TestConstructor {
    private long var;
    private TestConstructor(long param) {
        var = param;
    }
    public static void main(String[] args) {
        TestConstructor a, b;
//        a = new TestConstructor();
        b = new TestConstructor(5);
    }
}
