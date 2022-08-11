package back;

import java.util.*;

/**
 * @author shenWenWen 2021/5/5 下午4:15
 */
public class SubsetsWithDup {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        if (length <= 0) {
            return lists;
        }
        Arrays.sort(nums); //排序
        dfs(nums, length, new LinkedList<Integer>(), 0, lists);
        return lists;
    }

    private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            getAns(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    private static void dfs(int[] nums, int length, Queue<Integer> list, int begin, List<List<Integer>> lists) {
        lists.add(new ArrayList<>(list));
        for (int i = begin; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, length,list,i + 1, lists);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        subsetsWithDup(nums);
    }
}
