package algorithm.str;

import java.util.Scanner;

public class LengthOfLastWord {
    // 最后一个单词的长度
    private static int lengthOfLastWord(String s) {
        int len = s.length();
        int p = len - 1;
        char space = ' ';
        int lastValidIdx = len - 1;
        while ((s.charAt(lastValidIdx) == space) && (lastValidIdx > 0)) {
            -- lastValidIdx;
        }
        while ((s.charAt(p) != space) && (p > 0)) {
            -- p;
        }
        if ((p == 0) && (s.charAt(p) != space)) {
            -- p;
        }
        return (lastValidIdx - p);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String s = in.nextLine();
            System.out.println(lengthOfLastWord(s));
        }
    }
}
