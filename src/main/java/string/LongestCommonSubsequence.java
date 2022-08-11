package string;

/**
 * 查询两个字符串的最长公共子序列长度
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 *
 * @author shenWenWen 2021/7/11 下午4:31
 */

/**
 *       a  b  c  d  e
 *    0  1  2  3  4  5
 * a  1  1  1  1  1  1
 * c  2  1  1  2  2  2
 * e  3  2  2  2  2  3
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //边界判断
        if (m == 0 || m == 0) {
            return 0;
        }
        //初始化数组
        int[][] dp = new int[m + 1][n + 1];
        //两层循环
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //dp方程 dp[i]==dp[j]  max(dp[i-1][j],dp[i][j-1])+1
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //max(dp[i-1][j],dp[i][j-1])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int temp = longestCommonSubsequence("abcde", "ace");
        System.out.println(temp);
    }

}
