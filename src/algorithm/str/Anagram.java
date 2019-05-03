package algorithm.str;

import java.util.logging.Logger;

// Leetcode 242  有效的字母异位词
public class Anagram {
    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        boolean res = true;
        int[] h1 = new int[26];
        int[] h2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++ h1[s.charAt(i) - 'a'];
            ++ h2[t.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if (h1[i] != h2[i]) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "rat";
        String t2 = "car";
        System.out.println(new Anagram().isAnagram(s1, t1));
        System.out.println(new Anagram().isAnagram(s2, t2));
    }
}
