package hash;

import java.util.*;

/**
 * @author shenWenWen 2022/5/6 下午2:33
 */
public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> ret = new LinkedList<>();
        for (int i = 1; i <= numbers.length; i++) {
            int num = target - numbers[i-1];
            if (map.containsKey(num)){
                ret.add(map.get(num));
                ret.add(i);
            }
            map.put(numbers[i-1],i);
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] num = {3,2,4};
        int[] ints = twoSum(num,6);
        System.out.println(ints);
    }
}
