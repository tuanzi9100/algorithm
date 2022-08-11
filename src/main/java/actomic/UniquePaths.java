package actomic;

import java.util.Arrays;

/**
 * 2021.04.25
 * @author shenWenWen 2021/4/29 上午10:02
 */
public class UniquePaths {
    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * <p>
     * 问总共有多少条不同的路径？
     * <p>
     */
    /**
     * 输入：m = 3, n = 7
     * 输出：28
     * <p>
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     * <p>
     * 输入：m = 7, n = 3
     * 输出：28
     * <p>
     * 输入：m = 3, n = 3
     * 输出：6
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
    /**
     *  1  1  1  1
     *  1  2  3  4
     *  1  3  6 10
     *
     *  1  3  6 10
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }


    public static int uniquePaths3(int m, int n) {
        //pre 作为对比的模版数据
        int[] pre = new int[n];
        int[] left = new int[n];
        Arrays.fill(pre,1);
        Arrays.fill(left,1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                left[j] = left[j - 1] + pre[j];
            }
            //将新的数据科隆到模版里面
            pre = left.clone();
        }
        return left[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths2(3, 7));
    }
}
