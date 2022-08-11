package node;

import java.util.Arrays;

/**
 * @author shenWenWen 2021/4/18 下午3:22
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, len);
                for (int j = i; j <len; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }

    public static void nextPermutation2(int[] nums) {
        int end = nums.length-1;
        int start = 0;
        boolean find =false;
        for(int j=end;j>0;j--){
            if(nums[j-1]<nums[j]){ //从后往前找到第一个升序的相邻数对，即nums[j-1]<nums[j]
                for(int k=end;k>j-1;k--){ //再从后往前找到第一个比nums[j-1]大的数，交换他们
                    if(nums[k]>nums[j-1]){
                        int temp = nums[j-1];
                        nums[j-1] = nums[k];
                        nums[k] = temp;
                        start = j; //交换的数的下一个位置，要保证之后升序排列
                        find = true;
                        break;
                    }
                }
            }
            if(find) {
                break;
            }
        }
        while(start<=end){ //刚刚的算法已经保证j~end是降序排列了，把它们弄成升序只需要头尾交换即可
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation2(nums);
    }
}
