package container;

public class StrExample {
    private void testStr() {
        String str1 = "abc"; //������
        String str2 = new String("abc"); //��
        String str3 = str2.intern(); //���س���������
        System.out.println(str1 == str2);
        System.out.println(str3 == str2);
        System.out.println(str1 == str3);
    }

    public static void main(String[] args) {
        StrExample strObj = new StrExample();
        strObj.testStr();
    }
}
