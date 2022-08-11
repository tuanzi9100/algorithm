package num;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author shenWenWen 2021/4/20 下午11:05
 */
public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth,
                            Deque<Integer> path, boolean[] used,
                            List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点 的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.removeLast();
            }
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        if (length == 0) {
            return lists;
        }
        ArrayDeque<Integer> list = new ArrayDeque<>();
        boolean[] isUsed = new boolean[length];
        dfs2(nums, length, lists, 0, isUsed, list);
        return lists;
    }

    private static void dfs2(int[] nums, int length, List<List<Integer>> lists, int deep, boolean[] isUsed, Deque<Integer> list) {
        if (length == deep) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!isUsed[i]) {
                list.addLast(nums[i]);
                isUsed[i] = true;

                dfs2(nums, length, lists, deep + 1, isUsed, list);
                isUsed[i] = false;
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute2(nums);
        System.out.println(permute);
    }
}
