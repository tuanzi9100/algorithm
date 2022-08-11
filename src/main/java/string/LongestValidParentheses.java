package string;

import java.util.Stack;

/**
 * @author shenWenWen 2021/4/18 下午3:55
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
    if (s=="" || s==null){
        return 0;
    }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char aChar = chars[i];
            if (aChar == '('){
                stack.push(aChar);
                continue;
            }
            if (aChar == ')' ){

            }
        }
        return 0;
    }
    public static int longestValidParentheses2(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses2("()("));;
    }
}
