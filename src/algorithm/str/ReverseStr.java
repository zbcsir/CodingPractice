package algorithm.str;

public class ReverseStr {
    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len>>1; i++) {
            char t = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = t;
        }
        print(s);
    }

    private void print(char[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        ReverseStr rs = new ReverseStr();
        rs.reverseString(s);
    }
}
