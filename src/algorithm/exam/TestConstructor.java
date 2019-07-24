package algorithm.exam;

/**
 * 构造函数测试
 * 当存在有参构造函数时，Java将不再生成默认的午餐构造函数，第14行的代码将编译不通过
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
