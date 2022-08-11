package hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author shenWenWen 2022/5/6 下午4:32
 */
public class FindNumsAppearOnce {
    public static int[] FindNumsAppearOnce(int[] array) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                map.put(array[i],map.get(array[i]) + 1);
            }else {
                map.put(array[i],1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() != 1){
                iterator.remove();
            }
        }
        return map.keySet().stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1,4,1,6};
        int[] ints = FindNumsAppearOnce(arr);
        System.out.println(ints);
    }
}
