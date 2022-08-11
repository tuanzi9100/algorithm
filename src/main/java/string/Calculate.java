package string;

import java.util.Stack;

/**
 * @author shenWenWen 2021/3/21 下午10:05
 * 计算器
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * 输入: "3+2*2"
 * 输出: 7
 * <p>
 * leetCode 面试题 16.26. 计算器
 */
public class Calculate {

    /**
     * trim()的作用是去掉字符串两端的多余的空格，注意，是两端的空格，且无论两端的空格有多少个都会去掉，当然
     * 中间的那些空格不会被去掉
     *
     * @param s
     * @return
     */

    /**
     * 字符‘0’对应的ASCII码是48，48对应的十六进制数就是0x30，通常我们在编程的时候，用字符转化为数字的时候经常要用到，
     * 比如要将‘8’转换为数字8，在语句中这样写就可以了，“ 8+‘0’”。这里的8就是数字。
     * @param s
     * @return
     */
    public static int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack stack = new Stack();

        for (int i = 1; i < s.length() - 1; i++) {

            if (chars[i] == '+') {
                stack.push(chars[i]);
            }
            if (chars[i] == '-') {
                stack.push(-chars[i]);
            }
            /*if (chars[i] == '*') {
                stack.push(stack.peek() * chars[i]);
            }*/
            if (chars[i] == '/') {
                stack.push(chars[i]);
            }

            if (chars[i] != '+' && chars[i] != '-' && chars[i] != '*' && chars[i] != '/') {
                stack.push(chars[i]);
            }
        }

        int count = 0;
        for (int i = 0; i < stack.size(); i++) {
            // count += stack.pop();
        }
        return count;
    }

    public static int ca2(String s) {
        char[] cs = s.trim().toCharArray();
        Stack<Integer> st = new Stack();
        int ans = 0, i = 0;
        while (i < cs.length) {
            if (cs[i] == ' ') {
                i++;
                continue;
            }
            char tmp = cs[i];
            if (tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-') {
                i++;
                while (i < cs.length && cs[i] == ' ') {
                    i++;
                }
            }
            int num = 0;
            while (i < cs.length && Character.isDigit(cs[i])) {
                num =  num * 10+ cs[i] - '0';
                i++;
            }
            switch (tmp) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = st.pop() * num;
                    break;
                case '/':
                    num = st.pop() / num;
                    break;
                default:
                    break;
            }
            st.push(num);
        }
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "3+2*2";
        System.out.println(ca2(str));
    }

}
