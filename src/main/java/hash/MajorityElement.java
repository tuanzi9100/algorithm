package hash;

/**
 * @author shenWenWen 2022/5/6 下午3:31
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = majorityElement(num);
        System.out.println();
    }
}
