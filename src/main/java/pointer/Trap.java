package pointer;

/**
 * 接雨水
 *
 * @author shenWenWen 2021/4/6 下午9:11
 */
public class Trap {

    public static int trap(int[] height) {
        int sum = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            //出错了
            //if (leftMax < rightMax) {
            if (height[left] < height[right]) {
                //先做加减，再东指针
                sum += leftMax - height[left];
                left++;
            } else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap2(arr);
        System.out.println(trap);
    }

    public static int trap2(int[] height) {

        int left= 0,right = height.length-1;
        int sum = 0;
        int leftMax = 0,rightMax = 0;
        while (left<right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]){
                sum += leftMax-height[left];
                left++;
            }else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }
}
