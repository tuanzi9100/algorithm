package hash;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author shenWenWen 2022/5/6 下午5:40
 */
public class ThreeSum {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        //1、排序
        Arrays.sort(num);
        //枚举a,声明l、r l=i+1 r=len-1 l+r>0 则r--,l+r<0 则b--
        int length = num.length;
        for (int i = 0; i < length; ++i) {
            //如果num[i]>0,则最小值大于0，不可能存在=0的情况。
            if (num[i] > 0) {
                return lists;
            }
            //如果num[i]==num[i+1],就跳出循环
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int l = i + 1, r = length - 1;
            while (l < r) {
                int temp = num[i] + num[l] + num[r];
                if (temp == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[l]);
                    list.add(num[r]);
                    lists.add(list);
                    while (l < r && num[l + 1] == num[l]) {
                        ++l;
                    }
                    while (l < r && num[r - 1] == num[r]) {
                        --r;
                    }
                    ++l;
                    --r;
                } else if (temp > 0) {
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] arr = {-10, 0, 10, 20, -10, -40};
        ArrayList<ArrayList<Integer>> arrayLists = threeSum(arr);
        System.out.println(arrayLists);
    }
}
