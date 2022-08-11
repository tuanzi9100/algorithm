package array;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author shenWenWen 2022/5/5 下午7:22
 */
public class SmallestK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) ->a-b);
        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ret.add(queue.poll());
        }
        return ret;
    }
}
