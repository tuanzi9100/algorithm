package actomic;

/**
 * @author shenWenWen 2021/4/24 下午11:00
 */
public class CanJump {

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        boolean b = canJump(arr);
    }
}
