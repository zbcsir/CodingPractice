package algorithm.stack;

import java.util.Stack;

/**
 * ÓÐÐ§À¨ºÅ
 */
public class ValidBrackets {
    private static boolean isValid(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        if (s.charAt(0) == '}' || s.charAt(0) == ')' || s.charAt(0) == ']') {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            if ((c == '(') || (c == '{') || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty()){
                Character pop = stack.peek();
                if ((pop == '(' && c == ')') || (pop == '{' && c == '}') || (pop == '[' && c == ']')) {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "([)]";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
    }
}
