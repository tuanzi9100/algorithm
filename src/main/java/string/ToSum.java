package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * @author shenwenwen
 */
public class ToSum {

    public static int[] toSum(int[] numbs, int target) {
        Map<Integer, Integer> num2IndexMap = new HashMap<Integer, Integer>(16);
        for (int i = 0; i < numbs.length; i++) {
            if (num2IndexMap.containsKey(target - numbs[i])) {
                return new int[]{num2IndexMap.get(target - numbs[i]), i};
            }
            num2IndexMap.put(numbs[i], i);
        }
        return new int[0];
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static int[] toSum2(int[] numbs, int target) {
        Map<Integer, Integer> num2IndexMap = new HashMap<>(16);
        for (int i = 0; i < numbs.length; i++) {
            int num = target - numbs[i];
            if (num2IndexMap.containsKey(num)) {
                return new int[]{num2IndexMap.get(num), i};
            }
            num2IndexMap.put(numbs[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        System.out.println(toSum2(arr, 9).toString());
    }

}
