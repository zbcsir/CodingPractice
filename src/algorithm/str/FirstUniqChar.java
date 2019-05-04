package algorithm.str;

// Leetcode 387  字符串中的第一个唯一字符
// 假定该字符串只包含小写字母
public class FirstUniqChar {
    public int firstUniqCharOld(String s) {
        int[] nums = new int[26];
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            ++ nums[s.charAt(i)-'a'];
        }
        for (int i = 0; i < s.length(); i++) {
            if (nums[s.charAt(i)-'a'] == 1) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    // 2ms的解法
    private int firstUniqChar(String s) {
        int idx = -1;
        for (int c = 'a'; c <= 'z'; c++) {
            int firstIdx = s.indexOf(c);
            int lastIdx = s.lastIndexOf(c);
            if ((firstIdx != -1) && (firstIdx == lastIdx)) {
                idx = (idx == -1 ? firstIdx : Math.min(idx, firstIdx));
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        FirstUniqChar fuc = new FirstUniqChar();
        System.out.println(fuc.firstUniqChar(s1));
        System.out.println(fuc.firstUniqChar(s2));
    }
}
