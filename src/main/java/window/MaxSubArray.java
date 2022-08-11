package window;

/**
 * -2,1,-3,4,-1,2,1,-5,4]
 * @author shenWenWen 2022/4/10 下午6:10
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }
        int left = 0,right=0,window=0;
        int max = 0;

        for (int i = 0; i < nums.length-1; i++) {
            if (max > max + nums[i]) {
                right++;
            }else {
                left = i+1;
            }
            window = right-left+1;
        }
       return nums.length;
    }

    public static int maxSubArray2(int[] nums) {
        //定义两个值，一个表示最后位置，一个表示最大值
        int endIndex = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            endIndex = Math.max(nums[i],endIndex+nums[i]);
            maxSum = Math.max(maxSum,endIndex);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray2(arr);
    }
}
