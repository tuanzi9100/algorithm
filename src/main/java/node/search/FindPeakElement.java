package node.search;

/**
 * @author shenWenWen 2022/4/24 下午1:29
 */
public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left<right){
            int mid = left +(right-left)/2;
            if (nums[mid]<nums[mid+1]){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,2,1};
        int peakElement = findPeakElement(num);
        System.out.println(peakElement);
    }
}
