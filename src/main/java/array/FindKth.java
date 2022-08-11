package array;

import java.util.PriorityQueue;

/**
 * @author shenWenWen 2022/5/5 下午10:16
 */
public class FindKth {
    public static int findKth(int[] a, int n, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((c,d)->d-c);
        for (int i = 0; i < n; i++) {
            queue.offer(a[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (i == K){
                return queue.poll();
            }
            queue.poll();
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int[] arr = {13,11,5,6,12,13,5};
        findKth(arr,7,4);
    }
}
