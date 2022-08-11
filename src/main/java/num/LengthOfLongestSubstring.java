package num;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenWenWen 2021/3/23 上午9:57
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {


    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;//最长子串长度
        int left = 0;//滑动窗口左下标，i相当于滑动窗口右下标
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {//charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
                left = Math.max(left, map.get(s.charAt(i)) + 1);       //map.get():返回字符所对应的索引，当发现重复元素时，窗口左指针右移
            }        //map.get('a')=0,因为map中只有第一个a的下标，然后更新left指针到原来left的的下一位
            map.put(s.charAt(i), i);      //再更新map中a映射的下标
            max = Math.max(max, i - left + 1);     //比较两个参数的大小
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //定义一个滑动窗口 key为字符，value为下标。
        Map<Character, Integer> window = new HashMap<>(16);
        int max = 0;
        char[] chars = s.toCharArray();
        //定义快慢指针
        for (int slow = 0, fast = 0; fast < s.length(); fast++) {
            char aChar = chars[fast];
            if (window.containsKey(aChar)) {
                //下一个慢指针的位置=慢指针为重复元素的下标+1
                //slow = Math.max(window.get(s.charAt(slow)) + 1, fast);出现错误。
                slow = Math.max(window.get(s.charAt(slow)) + 1, slow);
            }
            //最大窗口=慢指针-快指针+1
            max = Math.max(max, fast - slow + 1);
            window.put(s.charAt(fast), fast);
        }
        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        for (int slow = 0, fast = 0; fast < s.length(); fast++) {
            if (window.containsKey(chars[fast])) {
                slow = Math.max(chars[fast], slow);
            }
            max = Math.max(fast - slow + 1, max);
            window.put(chars[fast], fast);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("advdf"));
    }
}
