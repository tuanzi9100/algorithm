package num;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * @author shenWenWen 2021/4/20 下午5:32
 */
public class CombinationSum {
    /**
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     * [7],
     * [2,2,3]
     * ]
     *
     * @param candidates 数组
     * @param target     目标数字
     *                   基于以上的想法，可以画出如下的树形图。建议大家自己在纸上画出这棵树，这一类问题都需要先画出树形图，然后编码实现。
     *                   编码通过 深度优先遍历 实现，使用一个列表，在 深度优先遍历 变化的过程中，遍历所有可能的列表并判断当前列表是否符合题目的要求，成为「回溯算法」（个人理解，非形式化定义）。
     *                   以 target = 7 为 根结点 ，创建一个分支的时 做减法 ；
     *                   每一个箭头表示：从父亲结点的数值减去边上的数值，得到孩子结点的数值。边的值就是题目中给出的 candidate 数组的每个元素的值；
     *                   减到 00 或者负数的时候停止，即：结点 00 和负数结点成为叶子结点；
     *                   所有从根结点到结点 00 的路径（只能从上往下，没有回路）就是题目要找的一个结果。
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序是剪枝的前提
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }

    /**
     * 7
     * 5        4         1          0
     * 3  2  -1  -2  2 1 -2 -3  -1 -2 -5 -6  -2 -3 -6 -7
     * 1 0 0-1
     * -1
     */

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int length = candidates.length;
        List<List<Integer>> lists = new ArrayList<>();
        if (length == 0) {
            return lists;
        }
        //排序是剪枝的基础
        Arrays.sort(candidates);
        ArrayDeque<Integer> list = new ArrayDeque<>();
        dfs2(candidates, target, lists, list, 0, length);
        return lists;
    }

    private static void dfs2(int[] candidates, int target, List<List<Integer>> lists, Deque<Integer> list, int begin, int length) {
        if (target == 0) {
            lists.add(new ArrayList<Integer>(list));
        }
        for (int i = begin; i < length; i++) {
            //剪枝
            if (target - candidates[i] < 0) {
                return;
            }
            list.addLast(candidates[i]);
            dfs2(candidates, target - candidates[i], lists, list, i, length);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        List<List<Integer>> lists = combinationSum2(arr, 7);
        System.out.println(lists);
    }
}
