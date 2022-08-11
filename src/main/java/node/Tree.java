package node;

/**
 * @author shenWenWen 2021/7/20 下午2:17
 */
public class Tree {
    public static int right_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                // 注意
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        // 注意
        return left - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int i = right_bound(nums, 2);
        System.out.println(i);
    }
}
