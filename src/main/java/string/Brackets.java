package string;

import java.util.Stack;

/**
 * 给定一个只包含'（'，'）'{'， '}'的字符，判断字符串是否有效。
 *
 * @author shenWenWen 2021/4/8 下午8:20
 */
public class Brackets {

    public static boolean isBrackets(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
                continue;
            }
            if (chars[i] == ')' && (stack.size() ==0 || stack.peek() != '(')) {
                return false;
            }
            if (chars[i] == ']' && (stack.size() ==0 || stack.peek() != '[')) {
                return false;
            }
            if (chars[i] == '}' && (stack.size() ==0 || stack.peek() != '{')) {
                return false;
            }
            stack.pop();
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isBrackets("){"));
    }
}
