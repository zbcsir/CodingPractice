package algorithm.str;

import java.util.*;

// 无重复字符的最长子串
public class LengthOfLongestSubstring {
    private static int lengthOfLongestSubstring(String s) {
        int strLen = s.length();
        if (strLen == 0) {
            return 0;
        }
        int maxLen = 1;
        int[] len = new int[strLen];
        HashSet<Character> sub = new HashSet<>();
        for (int i = 0; i < strLen; i++) {
            len[i] = 1;
        }
        sub.add(s.charAt(0));
        for (int i = 1; i < strLen; i++) {
            if (!sub.contains(s.charAt(i))) {
                len[i] = len[i-1] + 1;
                sub.add(s.charAt(i));
            }
        }
        for (int e : len) {
            maxLen = e > maxLen ? e : maxLen;
        }
        return maxLen;
    }

    // 基于双指针
    private static int lengthOfLongestSubstringDouble(String s) {
        int strLen = s.length();
        if (strLen == 0) {
            return 0;
        }
        int maxLen = 1;
        int p1 = 0, p2 = 0;
        HashSet<Character> set = new HashSet<>();
        while (p1 < strLen && p2 < strLen) {
            if (!set.contains(s.charAt(p1))) {
                set.add(s.charAt(p1++));
                maxLen = Math.max(maxLen, (p1 - p2));
            } else {
                set.remove(s.charAt(p2++));
            }
        }
        return maxLen;
    }

    // 优化双指针版
    private static int lengthOfLongestSubstring1(String s) {
        int strLen = s.length();
        if (strLen == 0) {
            return 0;
        }
        int maxLen = 1;
        Map<Character, Integer> idx = new HashMap<>();
        for (int i = 0, j=0; i < strLen; i++) {
            if (idx.containsKey(s.charAt(i))) {
                j = Math.max(j, idx.get(s.charAt(i)));
            }
            maxLen = Math.max(maxLen, i - j + 1);
            idx.put(s.charAt(i), i+1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));
        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2));
        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3));
        String s4 = "abcde";
        System.out.println(lengthOfLongestSubstring(s4));
        String s5 = "";
        System.out.println(lengthOfLongestSubstring(s5));
        String s6 = "dvdf";
        System.out.println(lengthOfLongestSubstring(s6));
//        System.out.println(new Random().nextInt());
    }
}
