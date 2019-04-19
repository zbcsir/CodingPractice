package algorithm.trace;

import java.util.ArrayList;
import java.util.List;

// LeetCode 22Ìâ£ºÀ¨ºÅÉú³É
public class GenerateParenthesis {
    List<String> res;
    private List<String> generateParenthesis (int n) {
        res = new ArrayList<>(n*2);
        generate(0, 0, "", n);
        for (String item : res) {
            System.out.print(item + "\t");
        }
        return res;
    }

    void generate (int left, int right, String p, int num) {
        if ((left == num) && (right == num)) {
            res.add(p);
        }
        if (left < num) {
            generate(left + 1, right, p + "(", num);
        }
        if ((right < num) && (right < left)) {
            generate(left, right + 1, p + ")", num);
        }
    }

    public static void main(String[] args) {
        new GenerateParenthesis().generateParenthesis(3);
    }
}
