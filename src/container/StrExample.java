package container;

public class StrExample {
    private void testStr() {
        String str1 = "abc"; //常量池
        String str2 = new String("abc"); //堆
        String str3 = str2.intern(); //返回常量池引用
        System.out.println(str1 == str2);
        System.out.println(str3 == str2);
        System.out.println(str1 == str3);
    }

    public static void main(String[] args) {
        StrExample strObj = new StrExample();
        strObj.testStr();
    }
}
