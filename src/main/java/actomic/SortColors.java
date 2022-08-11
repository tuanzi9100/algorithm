package actomic;

/**
 * 颜色分类
 * 2021.04.29
 *
 * @author shenWenWen 2021/4/29 下午3:04
 */
public class SortColors {
    /**
     * 单指针法
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[pre];
                nums[pre] = temp;
                pre++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[pre];
                nums[pre] = temp;
                pre++;
            }
        }
    }

    /**
     * 双指针法
     *
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        int pre0 = 0, pre2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (i <= pre2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[pre2];
                nums[pre2] = temp;
                --pre2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[pre0];
                nums[pre0] = temp;
                pre0++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors2(arr);
    }
}
