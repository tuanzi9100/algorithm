package array;

import java.util.Stack;

/**
 * @author shenWenWen 2022/5/5 下午6:01
 */
public class IsValid {
    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
                continue;
            }
            if (chars[i] == ')' && (stack.isEmpty() || stack.peek() != '(')) {
                return false;
            }
            if (chars[i] == ']' && (stack.isEmpty() || stack.peek() != '[')) {
                return false;
            }
            if (chars[i] == '}' && (stack.isEmpty() || stack.peek() != '{')) {
                return false;
            }
            stack.pop();
        }
        return stack.size() == 0;
    }
}
