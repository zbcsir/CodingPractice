package algorithm.exam;

import java.util.Scanner;

/**
 * 给定一列非负整数，求这些数连接起来能组成的最大的数
 * @ author: zbc
 */
public class TheLargestNum {

    private static String lagest(String[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (smaller(nums[i], nums[j])) {
                    String tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        for (String s : nums) {
            sb.append(s);
        }
        return sb.toString();
    }

    private static boolean smaller(String s1, String s2) {
        int len = s1.length() < s2.length() ? s1.length() : s2.length();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return true;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return false;
            }
        }
        return false;
    }

    private static void testStringBuiler() {
        String[] strs = {"hello", "world", "bjtu", "edu"};
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        System.out.println(sb.toString());
        System.out.println();
        sb = new StringBuilder();
        for (String s : strs) {
            sb.insert(0, s);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextLine();
        }
        System.out.println(Long.parseLong(lagest(nums)));
    }
}
