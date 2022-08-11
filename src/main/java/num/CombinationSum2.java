package num;

import java.util.*;

/**
 * @author shenWenWen 2021/5/5 下午4:00
 */
public class CombinationSum2 {
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
            if (i > begin && candidates[i] == candidates[i - 1]) {
                return;
            }
            list.addLast(candidates[i]);
            dfs2(candidates, target - candidates[i], lists, list, i + 1, length);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        combinationSum2(candidates, 8);
    }
}
