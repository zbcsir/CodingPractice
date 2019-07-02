package algorithm.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 17 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合
 */
public class LetterCombinations {

    private List<String> combinations = new ArrayList<>();
    private Map<String, String> num2Char = new HashMap<>();

    private void trace(String combination, String digitsRemain) {
        if (digitsRemain.length() == 0) {
            combinations.add(combination);
        } else {
            String digit = digitsRemain.substring(0,1);
            String letters = num2Char.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i+1);
                trace(combination + letter, digitsRemain.substring(1));
            }
        }
    }

    private List<String> letterCombinations(String digits) {
        if ("".equals(digits) || digits == null) {
            return new ArrayList<>(0);
        }
        num2Char.put("2", "abc");
        num2Char.put("3", "def");
        num2Char.put("4", "ghi");
        num2Char.put("5", "jkl");
        num2Char.put("6", "mno");
        num2Char.put("7", "pqrs");
        num2Char.put("8", "tuv");
        num2Char.put("9", "wxyz");
        trace("", digits);
        return combinations;
    }

    public static void main(String[] args) {
        List<String> comb = new LetterCombinations().letterCombinations("234");
        int count = 0;
        for (String s : comb) {
            count++;
            System.out.print(s + " === ");
        }
        System.out.println();
        System.out.println("共 " + count + " 个组合");
    }
}
