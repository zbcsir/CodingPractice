package algorithm.str;

import java.util.*;

public class WordBreak {
    // Leetcode 139 单词拆分1
    private boolean wordBreakCheck(String s, List<String> wordDict) {
        if (wordDict.size() == 0)
            return false;
        int len = s.length();
        boolean[] canbreak = new boolean[len + 1];
        canbreak[0] = true;
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        for (int i = 0; i <= len; i++) {
            for (int j = Math.max(0, i-maxLen); j < i; j++) {
                if (canbreak[j] && wordDict.contains(s.substring(j, i))) {
                    canbreak[i] = true;
                }
            }
        }
        return canbreak[len];
    }

    // LeetCode 140 单词拆分2
    private Map<String, List<String>> tmpsentences = new HashMap<>();
    private List<String> wordBreak(String s, List<String> wordDict) {
        List<String> sentences = new ArrayList<>();
        if (s.length() == 0) {
            sentences.add(""); //递归初始化？
            return sentences;
        }
        if (tmpsentences.containsKey(s)) {
            return tmpsentences.get(s);
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = wordBreak(s.substring(word.length()), wordDict);
                for (String sentence : sublist) {
                    sentences.add(word + (sentence.equals("") ? "" : " ") + sentence);
                }
            }
        }
        tmpsentences.put(s, sentences);
        return sentences;
    }

    public static void main(String[] args) {
        // test for 单词拆分1
        String s = "leetcode";
        String s2 = "applepenapple";
        String s3 = "catsandog";
        List<String> dict = Arrays.asList("leet", "code");
        List<String> dict2 = Arrays.asList("apple", "pen");
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreakCheck(s, dict));
        System.out.println(wb.wordBreakCheck(s2, dict2));
        System.out.println(wb.wordBreakCheck(s3, dict3));

        // test for 单词拆分2
        s = "catsanddog";
        List<String> worddict = Arrays.asList("cat", "cats" ,"sand", "and", "dog");
        List<String> sentences = wb.wordBreak(s, worddict);
        System.out.println(sentences.size());
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}
