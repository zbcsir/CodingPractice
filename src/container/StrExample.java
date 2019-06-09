package container;

// 字符串常量池测试
public class StrExample {
    private void testStr() {
        String str1 = "abc"; //常量池
        String str2 = new String("abc"); //堆
        String str3 = str2.intern(); //返回常量池引用
        System.out.println(str1 == str2);
        System.out.println(str3 == str2);
        System.out.println(str1 == str3);
    }

    private void internExample() {
        String s1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s1.intern() == s1); //true
        String s12 = new String("计算机软件");
        System.out.println(s12.intern() == s12); //false
        String s13 = "计算机软件";
        System.out.println(s13.intern() == s13); //

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2); //false
        String s22 = new String("java");
        System.out.println(s22.intern() == s22); //false
        String s23 = "java";
        System.out.println(s23.intern() == s23); //
    }

    public static void main(String[] args) {
        StrExample strObj = new StrExample();
//        strObj.testStr();
        strObj.internExample();
    }
}
