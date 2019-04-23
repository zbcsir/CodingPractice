package algorithm.str;

public class Palindrome {

    public boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 0)
            return true;
        s = s.toUpperCase();
        boolean res = true;
        int len = s.length();
        int i = 0, j = len - 1;
        while (i < j) {
            if (!isNumOrLetter(s.charAt(i))) {
                i++;
            } else if (!isNumOrLetter(s.charAt(j))){
                j--;
            } else {
                if (s.charAt(i) != s.charAt(j)) {
                    res = false;
                    break;
                }
                i++;
                j--;
            }
        }
        return res;
    }

    private boolean isNumOrLetter(char c) {
        return ((c >= '0') && (c <= '9') ||
                ((c >= 'A') && (c < 'Z')));
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 ="9;8'4P?X:1Q8`dOfJuJXD6FF,8;`Y4! YBy'Wb:ll;" +
                ";`;\"JI0c2uvD':!LAk:s\"!'0.!2B55.T1VI?00Du?1,l``" +
                "RFsc?Y?9vD5 K'3'1b!N8hn:'l. R:9:o`m1r.M2mrJ?`Wjv1`" +
                "G6i6G`1vjW`?Jrm2M.r1m`o:::R .l':nh8N!b1'3'K 5Dv9?Y?csFR``" +
                "l,1?uD00?IV1T.55B2!.0'!\"s:kAL!:'Dvu2c0IJ\";`;" +
                ";ll9bW'yBY !4Y`;8,FF6DXJuJfOd`8Q1:X?P4'8;9";
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(s1));
        System.out.println(p.isPalindrome(s2));
        System.out.println(p.isPalindrome(s3));
    }
}
