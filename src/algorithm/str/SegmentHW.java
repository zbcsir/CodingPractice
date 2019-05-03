package algorithm.str;

import java.util.ArrayList;
import java.util.List;

// Leetcode 131 分割回文串
public class SegmentHW {
    private List<List<String>> res_glo = new ArrayList<>();
    private List<String> eleRes = new ArrayList<>();
    private int strLen = 0;
    private List<List<String>> partition(String s) {
        strLen = s.length();
        List<List<String>> res = new ArrayList<>();
        partitionAndCheckV2(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void partitionAndCheckV1 (String s, int start) {
        if (start == strLen) {
            res_glo.add(new ArrayList<>(eleRes)); // Note:不能替换为 res.add(eleRes)
        }
        for (int i = 1; i <= strLen-start; i++) {
            if (isPalindrome(s.substring(start, start+i))) {
                eleRes.add(s.substring(start, start + i));
                partitionAndCheckV1(s, start + i);
                eleRes.remove(eleRes.size()-1);
            }
        }
    }

    private void partitionAndCheckV2 (String s, int start, List<String> eRes, List<List<String>> res) {
        if (start == strLen) {
            res.add(new ArrayList<>(eRes)); // Note:不能替换为 res.add(eleRes)
        }
        for (int i = start + 1; i <= strLen; i++) {
            if (isPalindrome(s.substring(start, i))) {
                eRes.add(s.substring(start, i));
                partitionAndCheckV2(s, i, eRes, res);
                eRes.remove(eRes.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        for(int i = 0; i <= s.length() >> 1; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    private void printRes(List<List<String>> res) {
        for (List<String> eList : res) {
            for (String e : eList) {
                System.out.print(e + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SegmentHW segmentHW = new SegmentHW();
        String s = "aab";
        List<List<String>> res = segmentHW.partition(s);
        segmentHW.printRes(res);
    }
}
