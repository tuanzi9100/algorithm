package node.search;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenWenWen 2022/4/23 下午10:36
 */
public class Search {
    public static int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        return -1;
    }

    public static int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (target == num) {
                return mid;
            } else if (target > num) {
                left = mid + 1;
            } else if (target < num) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 4, 6, 10, 13, 14};
        int search = search(nums, 13);
        System.out.println(search);
    }
}
