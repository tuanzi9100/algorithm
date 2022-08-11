package string;

import java.util.Arrays;

/**
 * 最长回文   不会
 *
 * @author shenWenWen 2021/3/23 上午10:05
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 */
public class LongestPalindrome {

    public class Solution {

        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;
            // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
            char[] charArray = s.toCharArray();

            // 枚举所有长度大于 1 的子串 charArray[i..j]
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
        }

        /**
         * 验证子串 s[left..right] 是否为回文串
         */
        private boolean validPalindromic(char[] charArray, int left, int right) {
            while (left < right) {
                if (charArray[left] != charArray[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }


    public String longestPalindrome2(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public static String longestPalindrome3(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int K = 0; K < n; ++K) {
            for (int i = 0; i + K < n; ++i) {
                int j = i + K;
                if (K == 0) {
                    dp[i][j] = true;
                } else if (K == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && K + 1 > ans.length()) {
                    ans = s.substring(i, i + K + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 动态规划
     * 字符  b a b a d
     * 下标  0 1 2 3 4
     * <p>
     * \子串右边界        0     1     2     3     4
     * 子串左边界
     * 0               true  false true false false
     * 1                     true false true false
     * 2                           true false false
     * 3                                true  false
     * 4                                       true
     *
     * @param s
     * @return
     */
    public static String longestPalindrome4(String s) {
        int l = s.length();
        //初始化二位数组
        boolean[][] dp = new boolean[l][l];
        //定义要返回的最长回文字串
        String max = "";

        //k为i和j之间的长度间隔
        for (int k = 0; k < l; k++) {
            for (int i = 0; i + k < l; i++) {
                int j = i + k;
                //对角线都为true,k为0的时候，i,j值一定相等，则为对角线。
                if (k == 0) {
                    dp[i][j] = true;
                }
                //间隔为1时的判断为，左右相等即可，即：i==j
                if (k == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    //否则，既要保证间隔前后的数据相等，还要保证i,j内部也是回文。
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i + 1][j - 1]);
                }
                //如果dp[i][j]为回文，并且长度大于最大回文长度，则最长回文更新为dp[i][j]的回文。
                if (dp[i][j] && k + 1 > max.length()) {
                    max = s.substring(i, i + k + 1);
                }
            }
        }
        //返回最大回文串
        return max;
    }

    public static void main(String[] args) {
        String babad = "babad";
        System.out.println(longestPalindrome3(babad));
    }
}
